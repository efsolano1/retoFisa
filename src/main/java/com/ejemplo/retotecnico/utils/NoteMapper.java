package com.ejemplo.retotecnico.utils;

import java.util.HashMap;
import java.util.Map;

public class NoteMapper {
    private static final Map<String, String> MAP = new HashMap<>();

    static {
        MAP.put("do", "z");
        MAP.put("re", "x");
        MAP.put("mi", "c");
        MAP.put("fa", "q");
        MAP.put("sol", "w");
        MAP.put("la", "e");
        MAP.put("si", "r");
        MAP.put("do2", "t");
    }

    private NoteMapper() {
    }

    /**
     * Devuelve la tecla del teclado asociada a la nota musical.
     *
     * @param note token de nota (ej. "do", "re", "sol")
     * @return tecla del teclado (ej. "z", "x", "c") o null si no existe
     */
    public static String map(String note) {
        if (note == null) return null;
        String token = note.trim().toLowerCase();
        return MAP.get(token);
    }
}
