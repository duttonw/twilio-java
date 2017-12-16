/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.understand.service;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class QueryCreator extends Creator<Query> {
    private final String pathServiceSid;
    private final String language;
    private final String query;
    private String intent;
    private String modelBuild;
    private String field;
    private String namedEntity;

    /**
     * Construct a new QueryCreator.
     * 
     * @param pathServiceSid The service_sid
     * @param language The language
     * @param query The query
     */
    public QueryCreator(final String pathServiceSid, 
                        final String language, 
                        final String query) {
        this.pathServiceSid = pathServiceSid;
        this.language = language;
        this.query = query;
    }

    /**
     * The intent.
     * 
     * @param intent The intent
     * @return this
     */
    public QueryCreator setIntent(final String intent) {
        this.intent = intent;
        return this;
    }

    /**
     * The model_build.
     * 
     * @param modelBuild The model_build
     * @return this
     */
    public QueryCreator setModelBuild(final String modelBuild) {
        this.modelBuild = modelBuild;
        return this;
    }

    /**
     * The field.
     * 
     * @param field The field
     * @return this
     */
    public QueryCreator setField(final String field) {
        this.field = field;
        return this;
    }

    /**
     * The named_entity.
     * 
     * @param namedEntity The named_entity
     * @return this
     */
    public QueryCreator setNamedEntity(final String namedEntity) {
        this.namedEntity = namedEntity;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Query
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Query create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/understand/Services/" + this.pathServiceSid + "/Queries",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Query creation failed: Unable to connect to server");
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

        return Query.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (language != null) {
            request.addPostParam("Language", language);
        }

        if (query != null) {
            request.addPostParam("Query", query);
        }

        if (intent != null) {
            request.addPostParam("Intent", intent.toString());
        }

        if (modelBuild != null) {
            request.addPostParam("ModelBuild", modelBuild.toString());
        }

        if (field != null) {
            request.addPostParam("Field", field.toString());
        }

        if (namedEntity != null) {
            request.addPostParam("NamedEntity", namedEntity.toString());
        }
    }
}