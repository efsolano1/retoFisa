package com.ejemplo.retotecnico.tasks;

import com.ejemplo.retotecnico.interactions.PressKey;
import com.ejemplo.retotecnico.utils.NoteMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import com.ejemplo.retotecnico.actions.Pause;

public class PlayNotes implements Task {
    private final String[] notes;
    private final long pauseMillis;

    public PlayNotes(String[] notes, long pauseMillis) {
        this.notes = notes;
        this.pauseMillis = pauseMillis;
    }

    public static PlayNotes sequence(String[] notes) {
        return Tasks.instrumented(PlayNotes.class, (Object) notes);
    }

    public static PlayNotes sequence(String[] notes, long pauseMillis) {
        return Tasks.instrumented(PlayNotes.class, (Object) notes, pauseMillis);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String noteToken : notes) {
            String key = NoteMapper.map(noteToken);
            if (key != null) {
                actor.attemptsTo(
                        PressKey.withKey(key),
                        Pause.forDuration(pauseMillis)
                );
            } else {
                actor.attemptsTo(Pause.forDuration(300L));
                System.out.println("Nota no encontrada: " + noteToken);
            }
        }
    }
}
