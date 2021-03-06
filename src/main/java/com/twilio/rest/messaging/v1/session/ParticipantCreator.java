/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1.session;

import com.twilio.base.Creator;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class ParticipantCreator extends Creator<Participant> {
    private final String pathSessionSid;
    private String identity;
    private String userAddress;
    private String attributes;
    private String twilioAddress;
    private DateTime dateCreated;
    private DateTime dateUpdated;

    /**
     * Construct a new ParticipantCreator.
     *
     * @param pathSessionSid The SID of the Session for the participant
     */
    public ParticipantCreator(final String pathSessionSid) {
        this.pathSessionSid = pathSessionSid;
    }

    /**
     * A JSON string that stores application-specific data..
     *
     * @param attributes A JSON string that stores application-specific data
     * @return this
     */
    public ParticipantCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * The address of the Twilio phone number, WhatsApp number, or Messenger Page ID
     * that the participant is in contact with. This field, together with
     * user_address, is only null when the participant is interacting from a Chat
     * endpoint (see the 'identity' field)..
     *
     * @param twilioAddress The address of the Twilio phone number that the
     *                      participant is in contact with
     * @return this
     */
    public ParticipantCreator setTwilioAddress(final String twilioAddress) {
        this.twilioAddress = twilioAddress;
        return this;
    }

    /**
     * The date, specified in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)
     * format, to assign to the resource as the date it was created. This is used
     * when importing messages from another system, as the provided value will be
     * trusted and displayed on SDK clients..
     *
     * @param dateCreated The ISO 8601 date and time in GMT when the resource was
     *                    created
     * @return this
     */
    public ParticipantCreator setDateCreated(final DateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    /**
     * The date, specified in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)
     * format, to assign to the resource as the date it was last updated. This is
     * used when importing messages from another system, as the provided value will
     * be trusted and displayed on SDK clients..
     *
     * @param dateUpdated The ISO 8601 date and time in GMT when the resource was
     *                    updated
     * @return this
     */
    public ParticipantCreator setDateUpdated(final DateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    /**
     * The application-defined string that uniquely identifies the [Chat
     * User](https://www.twilio.com/docs/chat/rest/user-resource) as the session
     * participant. This parameter is null unless the participant is using the
     * Programmable Chat SDK to communicate..
     *
     * @param identity The string that identifies the resource's User
     * @return this
     */
    public ParticipantCreator setIdentity(final String identity) {
        this.identity = identity;
        return this;
    }

    /**
     * The address of the participant's device. Can be a phone number or Messenger
     * ID. Together with the Twilio Address, this determines a participant uniquely.
     * This field (with twilio_address) is null when the participant is interacting
     * from a Chat endpoint (see the `identity` field)..
     *
     * @param userAddress The address of the participant's device
     * @return this
     */
    public ParticipantCreator setUserAddress(final String userAddress) {
        this.userAddress = userAddress;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Participant
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Participant create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.MESSAGING.toString(),
            "/v1/Sessions/" + this.pathSessionSid + "/Participants",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Participant creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Participant.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
        }

        if (userAddress != null) {
            request.addPostParam("UserAddress", userAddress);
        }

        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }

        if (twilioAddress != null) {
            request.addPostParam("TwilioAddress", twilioAddress);
        }

        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toString());
        }

        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toString());
        }
    }
}