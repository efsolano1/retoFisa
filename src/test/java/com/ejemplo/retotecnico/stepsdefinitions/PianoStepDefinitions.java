package com.ejemplo.retotecnico.stepsdefinitions;

import com.ejemplo.retotecnico.questions.PianoVisible;
import com.ejemplo.retotecnico.tasks.PlayNotes;
import com.ejemplo.retotecnico.ui.PianoPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class PianoStepDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario abre el sitio del piano")
    public void abrirSitio() {
        OnStage.theActorCalled("Usuario").wasAbleTo(Open.url(PianoPage.URL));
    }

    @When("el usuario reproduce la secuencia {string}")
    public void reproduceSecuencia(String secuencia) {
        String[] notes = secuencia.split("\\s+");
        OnStage.theActorInTheSpotlight().attemptsTo(PlayNotes.sequence(notes, 200L));
    }

    @When("el usuario reproduce la secuencia {string} two times")
    public void reproduceSecuenciaTwoTimes(String secuencia) {
        String[] notes = secuencia.split("\\s+");
        OnStage.theActorInTheSpotlight().attemptsTo(PlayNotes.sequence(notes, 200L));
        OnStage.theActorInTheSpotlight().attemptsTo(PlayNotes.sequence(notes, 200L));
    }

    @When("el usuario repite el escenario 1")
    public void repiteEscenario1() {
        String esc1 = "si si do re re do si la sol sol la si si la la";
        String[] notes = esc1.split("\\s+");
        OnStage.theActorInTheSpotlight().attemptsTo(PlayNotes.sequence(notes, 200L));
    }

    @Then("el piano debería estar visible")
    public void validarPiano() {
        OnStage.theActorInTheSpotlight().should(seeThat(PianoVisible.isVisible(), is(true)));
    }

}
