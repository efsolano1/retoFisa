package com.ejemplo.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PianoPage {
    public static final String URL = "https://www.musicca.com/es/piano";

    public static final Target PIANO_CONTAINER = Target.the("contenedor del piano")
            .locatedBy("//div[contains(@class,'piano') or contains(@class,'keys')]");

    public static final Target NOTE_KEY = Target.the("tecla con data-note {0}")
            .locatedBy("//span[@data-note='{0}']");
}
