package ru.yandex.practicum;

import java.io.Serial;

public class WordLengthMismatchException extends Exception {
    @Serial
    private static final long serialVersionUID = 2867301666167864149L;

    public WordLengthMismatchException(String message) {
        super(message);
    }
}