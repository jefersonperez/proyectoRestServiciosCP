package co.com.apirest.project.interactions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class SendRequestGetBooking implements Interaction {

    private final String id;

    public SendRequestGetBooking(String id) {
        this.id = id;
    }

    public static SendRequestGetBooking withId(String id) {
        return Tasks.instrumented(SendRequestGetBooking.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JsonPath result = SerenityRest.given().relaxedHTTPSValidation()
                .contentType("application/json")
                .get("https://restful-booker.herokuapp.com/booking/" + id)
                .jsonPath();

        actor.remember("responseJson", result.prettyPrint());

    }
}
