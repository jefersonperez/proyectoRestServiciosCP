package co.com.apirest.project.stepdefinition;

import co.com.apirest.project.interactions.SendRequestUpdateBooking;
import io.cucumber.java.Before;
import io.cucumber.java.an.Y;
import io.cucumber.java.es.*;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

public class UpdateBookingStepDefinitions {
    private final Actor userAutomation = Actor.named("userAutomation");

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Y("Se actualizan las reservas con los datos proporcionados")
    public void seActualizanLasReservasConLosDatosProporcionados(List<Map<String, Object>> table) {
        for (Map<String, Object> row : table) {
            userAutomation.attemptsTo(SendRequestUpdateBooking.withData(row));
        }
    }

 /*   @Entonces("Entonces El código de respuesta tiene que ser {int}")
    public void elCodigoDeRespuestaTieneQueSer(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }*/

    @Entonces("El nombre en la respuesta debe ser {string} para el primer libro")
    public void elNombreEnLaRespuestaDebeSerParaElPrimerLibro(String firstname) {
        String responseFirstname = SerenityRest.lastResponse().jsonPath().getString("firstname");
        assert responseFirstname.equals(firstname);
    }

    @Entonces("El nombre en la respuesta debe ser {string} para el segundo libro")
    public void elNombreEnLaRespuestaDebeSerParaElSegundoLibro(String firstname) {
        String responseFirstname = SerenityRest.lastResponse().jsonPath().getString("firstname");
        assert responseFirstname.equals(firstname);
    }
}
