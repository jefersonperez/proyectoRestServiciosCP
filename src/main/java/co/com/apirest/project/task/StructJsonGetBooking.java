package co.com.apirest.project.task;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class StructJsonGetBooking implements Task {
    private final String id;

    public StructJsonGetBooking(String id) {
        this.id = id;
    }

    public static StructJsonGetBooking withId(String id) {
        return Tasks.instrumented(StructJsonGetBooking.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JsonPath result = SerenityRest.given().relaxedHTTPSValidation()
                .contentType("application/json")
                .get("https://restful-booker.herokuapp.com/booking/" + id)
                .jsonPath();

        actor.remember("responseJson", result);
    }
}
