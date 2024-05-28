package co.com.apirest.project.stepdefinition;

import co.com.apirest.project.interactions.SendRequestDeleteBooking;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class DeleteBookingStepDefinitions {
    private final Actor userAutomation = Actor.named("userAutomation");

    // Preparando al actor
    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("Que se requiere eliminar los libros creados")
    public void queSeRequiereEliminarLosLibrosCreados() {
        // No se necesita implementar nada aquí
    }

    @Cuando("Se consume el servicio DeleteBooking para eliminar los libros")
    public void seConsumeElServicioDeleteBookingParaEliminarLosLibros() {
        userAutomation.attemptsTo(SendRequestDeleteBooking.withData());
    }


}
