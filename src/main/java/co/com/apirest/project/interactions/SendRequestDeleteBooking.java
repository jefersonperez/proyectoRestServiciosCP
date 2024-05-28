package co.com.apirest.project.interactions;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static co.com.apirest.project.utils.ConstanstString.*;

public class SendRequestDeleteBooking implements Interaction {

//    private final String endpoint;
//    private final String service;
//
//    public SendRequestDeleteBooking(String endpoint, String service) {
//        this.endpoint = endpoint;
//        this.service = service;
//    }
//
//    public static SendRequestDeleteBooking withData() {
//        return Tasks.instrumented(SendRequestDeleteBooking.class, END_POINT, SERVICEDELETEBOOKING);
//    }
//
//    @Override
//    public <T extends Actor> void performAs(T actor) {
//        String token = actor.recall("token");
//
//        SerenityRest.given().relaxedHTTPSValidation()
//                .header("Content-Type", JSON_HEADER)
//                .header("Cookie", "token=" + token)
//                .delete(endpoint + service);
//    }
private final String endpoint;
    private final String service;

    public SendRequestDeleteBooking(String endpoint, String service) {
        this.endpoint = endpoint;
        this.service = service;
    }

    public static SendRequestDeleteBooking withData() {
        return Tasks.instrumented(SendRequestDeleteBooking.class, END_POINT, SERVICEDELETEBOOKING);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall("token");

        Response response = SerenityRest.given().relaxedHTTPSValidation()
                .header("Content-Type", JSON_HEADER)
                .header("Cookie", "token=" + token)
                .delete(endpoint + service);

        // Imprimir la respuesta por consola
        System.out.println("Response: " + response.getBody().asString());
    }

}
