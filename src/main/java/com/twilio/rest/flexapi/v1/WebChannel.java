/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.flexapi.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebChannel extends Resource {
    private static final long serialVersionUID = 254450779434929L;

    public enum ChatStatus {
        INACTIVE("inactive");

        private final String value;

        private ChatStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a ChatStatus from a string.
         * @param value string value
         * @return generated ChatStatus
         */
        @JsonCreator
        public static ChatStatus forValue(final String value) {
            return Promoter.enumFromString(value, ChatStatus.values());
        }
    }

    /**
     * Create a WebChannelReader to execute read.
     *
     * @return WebChannelReader capable of executing the read
     */
    public static WebChannelReader reader() {
        return new WebChannelReader();
    }

    /**
     * Create a WebChannelFetcher to execute fetch.
     *
     * @param pathSid The SID of the WebChannel resource to fetch
     * @return WebChannelFetcher capable of executing the fetch
     */
    public static WebChannelFetcher fetcher(final String pathSid) {
        return new WebChannelFetcher(pathSid);
    }

    /**
     * Create a WebChannelCreator to execute create.
     *
     * @param flexFlowSid The SID of the FlexFlow
     * @param identity The chat identity
     * @param customerFriendlyName The chat participant's friendly name
     * @param chatFriendlyName The chat channel's friendly name
     * @return WebChannelCreator capable of executing the create
     */
    public static WebChannelCreator creator(final String flexFlowSid,
                                            final String identity,
                                            final String customerFriendlyName,
                                            final String chatFriendlyName) {
        return new WebChannelCreator(flexFlowSid, identity, customerFriendlyName, chatFriendlyName);
    }

    /**
     * Create a WebChannelUpdater to execute update.
     *
     * @param pathSid The SID that identifies the resource to update
     * @return WebChannelUpdater capable of executing the update
     */
    public static WebChannelUpdater updater(final String pathSid) {
        return new WebChannelUpdater(pathSid);
    }

    /**
     * Create a WebChannelDeleter to execute delete.
     *
     * @param pathSid The SID that identifies the resource to delete
     * @return WebChannelDeleter capable of executing the delete
     */
    public static WebChannelDeleter deleter(final String pathSid) {
        return new WebChannelDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a WebChannel object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return WebChannel object represented by the provided JSON
     */
    public static WebChannel fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WebChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a WebChannel object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return WebChannel object represented by the provided JSON
     */
    public static WebChannel fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WebChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String flexFlowSid;
    private final String sid;
    private final URI url;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;

    @JsonCreator
    private WebChannel(@JsonProperty("account_sid")
                       final String accountSid,
                       @JsonProperty("flex_flow_sid")
                       final String flexFlowSid,
                       @JsonProperty("sid")
                       final String sid,
                       @JsonProperty("url")
                       final URI url,
                       @JsonProperty("date_created")
                       final String dateCreated,
                       @JsonProperty("date_updated")
                       final String dateUpdated) {
        this.accountSid = accountSid;
        this.flexFlowSid = flexFlowSid;
        this.sid = sid;
        this.url = url;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    /**
     * Returns The The SID of the Account that created the resource and owns this
     * Workflow.
     *
     * @return The SID of the Account that created the resource and owns this
     *         Workflow
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The SID of the FlexFlow.
     *
     * @return The SID of the FlexFlow
     */
    public final String getFlexFlowSid() {
        return this.flexFlowSid;
    }

    /**
     * Returns The The unique string that identifies the WebChannel resource.
     *
     * @return The unique string that identifies the WebChannel resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The absolute URL of the WebChannel resource.
     *
     * @return The absolute URL of the WebChannel resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The ISO 8601 date and time in GMT when the resource was last
     * updated.
     *
     * @return The ISO 8601 date and time in GMT when the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WebChannel other = (WebChannel) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(flexFlowSid, other.flexFlowSid) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(url, other.url) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            flexFlowSid,
                            sid,
                            url,
                            dateCreated,
                            dateUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("flexFlowSid", flexFlowSid)
                          .add("sid", sid)
                          .add("url", url)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .toString();
    }
}