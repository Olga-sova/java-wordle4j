package ru.yandex.practicum;

import java.io.Serial;

public class DictionaryLoadingException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3991458318264207294L;

    public DictionaryLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
