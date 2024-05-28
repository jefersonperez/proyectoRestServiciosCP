package co.com.apirest.project.stepdefinition;

import co.com.apirest.project.interactions.SendRequest;
import co.com.apirest.project.task.StructJson;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static co.com.apirest.project.utils.ConstanstString.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AuthTokenStepDefinitions {
    private final Actor userAutomation = Actor.named("userAutomation");


    //Preparando al actor
    @Before
    public void prepareActorStage() {
        //Prepara todas las habilidades del actor (web, mobile, desktop)
        OnStage.setTheStage(new OnlineCast());
        //actor puede navegar en la web con el webdriver


    }


    @Then("Que se requiere conocer la informacion detallada de las solicitud")
    public void queSeRequiereConocerLaInformacionDetalladaDeLasSolicitud(List<Map<String, Object>> table) {

        userAutomation.remember("table", table);
    }

    @When("Se hace la busqueda del estado de solicitud con un solo filtro")
    public void seHaceLaBusquedaDelEstadoDeSolicitudConUnSoloFiltro() {
        userAutomation.attemptsTo(StructJson.withData());
        userAutomation.attemptsTo(SendRequest.toApiGateway(END_POINT, SERVICE, userAutomation.recall("json")));

    }


    @When("Se retorna la informacion detallada de la solicitud con el estado")
    public void seRetornaLaInformacionDetalladaDeLaSolicitudConElEstadoStatusExpected( ) {

    }
}
