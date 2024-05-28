package co.com.apirest.project.stepdefinition;

import co.com.apirest.project.interactions.SendRequestCreateBooking;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

public class CreateBookingStepDefinitions {
    private final Actor userAutomation = Actor.named("userAutomation");

    // Preparando al actor
    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Y("Se crean las reservas con los datos proporcionados")
    public void seCreanLasReservasConLosDatosProporcionados(List<Map<String, Object>> table) {
        for (Map<String, Object> row : table) {
            userAutomation.attemptsTo(SendRequestCreateBooking.withData(row));
        }
    }

    @Entonces("El código de respuesta debe ser {int}")
    public void elCodigoDeRespuestaDebeSer(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }


}
