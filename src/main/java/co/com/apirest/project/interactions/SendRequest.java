package co.com.apirest.project.interactions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static co.com.apirest.project.utils.ConstanstString.*;

public class SendRequest implements Interaction {

    private final String endpoint;
    private final String service;
    private final String jsonRequest;


    public SendRequest(String endpoint, String service, String jsonRequest) {
        this.endpoint = endpoint;
        this.service = service;
        this.jsonRequest = jsonRequest;
    }

    public static SendRequest toApiGateway(String endpoint, String service, String jsonRequest) {
        return Tasks.instrumented(SendRequest.class, endpoint, service, jsonRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        JsonPath result;
        SerenityRest.given().relaxedHTTPSValidation().contentType(JSON_HEADER)
                .body(jsonRequest)
                .baseUri(endpoint)
                .header(CLIENT_ID, VALUE_CLIENT_ID)
                .header(CLIENT_SECRET, VALUE_CLIENT_SECRET)
                .header(MESSAGE_ID, VALUE_MESSAGE_ID)
                .basePath(service)
                .when().post();
        result = SerenityRest.lastResponse().jsonPath();
        int status = SerenityRest.lastResponse().statusCode();
        actor.remember(SERVICE_STATUS, status);
        actor.remember(RESPONSE_JSON_REQUEST, result);

        String token = result.getString("token");
        System.out.println(token);

    }
}

