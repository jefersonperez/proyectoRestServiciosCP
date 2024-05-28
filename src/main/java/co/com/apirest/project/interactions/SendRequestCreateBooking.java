package co.com.apirest.project.interactions;

import co.com.apirest.project.models.CreateBookingModel;
import co.com.apirest.project.models.builders.CreateBookingBuilder;
import co.com.apirest.project.models.builders.CreateBookingDatesModels;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

import static co.com.apirest.project.utils.ConstanstString.*;

public class SendRequestCreateBooking implements Interaction {

    private final String endpoint;
    private final String service;
    private final Map<String, Object> bookingData;

    public SendRequestCreateBooking(String endpoint, String service, Map<String, Object> bookingData) {
        this.endpoint = endpoint;
        this.service = service;
        this.bookingData = bookingData;
    }

    public static SendRequestCreateBooking withData(Map<String, Object> bookingData) {
        return Tasks.instrumented(SendRequestCreateBooking.class, END_POINT, SERVICECREATEBOOKING, bookingData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall("token");

        CreateBookingDatesModels bookingDates = new CreateBookingDatesModels(
                bookingData.get("checkin").toString(),
                bookingData.get("checkout").toString()
        );

        CreateBookingModel booking = new CreateBookingBuilder()
                .withFirstname(bookingData.get("firstname").toString())
                .withLastname(bookingData.get("lastname").toString())
                .withTotalprice(Integer.parseInt(bookingData.get("totalprice").toString()))
                .withDepositpaid(Boolean.parseBoolean(bookingData.get("depositpaid").toString()))
                .withBookingdates(bookingDates)
                .withAdditionalneeds(bookingData.get("additionalneeds").toString())
                .build();

        Gson gson = new Gson();
        String bookingJson = gson.toJson(booking);

        JsonPath result = SerenityRest.given().relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(bookingJson)
                .post(endpoint + service)
                .jsonPath();

        int statusCode = SerenityRest.lastResponse().statusCode();
        actor.remember(SERVICE_STATUS, statusCode);
        actor.remember(RESPONSE_JSON_REQUEST, result);

        System.out.println("Response: " + result.prettyPrint());
    }
}
