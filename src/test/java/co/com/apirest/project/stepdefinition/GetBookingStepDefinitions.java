package co.com.apirest.project.stepdefinition;

import co.com.apirest.project.interactions.SendRequestGetBooking;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class GetBookingStepDefinitions {
    private final Actor userAutomation = Actor.named("userAutomation");

    // Preparando al actor
    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("Se consultan los libros creados")
    public void seConsultanLosLibrosCreados() {
        userAutomation.attemptsTo(SendRequestGetBooking.withId("1")); // Cambiar el ID según sea necesario
    }


}
