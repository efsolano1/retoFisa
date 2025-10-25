package com.ejemplo.retotecnico.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import java.util.concurrent.TimeUnit;

public class Pause implements Performable {
    private final long duration;

    private Pause(long duration) {
        this.duration = duration;
    }

    public static Pause forDuration(long duration) {
        return new Pause(duration);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}