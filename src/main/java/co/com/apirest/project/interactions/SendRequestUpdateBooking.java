package co.com.apirest.project.interactions;

import co.com.apirest.project.models.UpdateBookingModel;
import co.com.apirest.project.models.builders.UpdateBookingBuilder;
import co.com.apirest.project.models.builders.UpdateBookingDatesModels;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

import static co.com.apirest.project.utils.ConstanstString.*;

public class SendRequestUpdateBooking implements Interaction {

    private final String endpoint;
    private final String service;
    private final Map<String, Object> bookingData;

    public SendRequestUpdateBooking(String endpoint, String service, Map<String, Object> bookingData) {
        this.endpoint = endpoint;
        this.service = service;
        this.bookingData = bookingData;
    }

    public static SendRequestUpdateBooking withData(Map<String, Object> bookingData) {
        int bookingId = Integer.parseInt(bookingData.get("bookingid").toString());
        return Tasks.instrumented(SendRequestUpdateBooking.class, END_POINT, SERVICEUPDATEBOOKING + bookingId, bookingData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall("token");

        UpdateBookingDatesModels bookingDates = new UpdateBookingDatesModels(
                bookingData.get("checkin").toString(),
                bookingData.get("checkout").toString()
        );

        UpdateBookingModel booking = new UpdateBookingBuilder()
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
                .put(endpoint + service)
                .jsonPath();

        int statusCode = SerenityRest.lastResponse().statusCode();
        actor.remember(SERVICE_STATUS, statusCode);
        actor.remember(RESPONSE_JSON_REQUEST, result);



       // System.out.println("Response: " + result.prettyPrint());
        //System.out.println("Response: " + result);
        System.out.println("Response: " + result.toString());


    }
}
