package com.ejemplo.retotecnico.questions;

import com.ejemplo.retotecnico.ui.PianoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PianoVisible implements Question<Boolean> {

    public static PianoVisible isVisible() {
        return new PianoVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return PianoPage.PIANO_CONTAINER.resolveFor(actor).isVisible();
    }
}