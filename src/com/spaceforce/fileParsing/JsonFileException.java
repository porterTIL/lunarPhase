package com.spaceforce.fileParsing;

import java.io.IOException;

public class JsonFileException extends IOException {
    public JsonFileException() {
    }

    public JsonFileException(String message) {
        super(message);
    }

    public JsonFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonFileException(Throwable cause) {
        super(cause);
    }
}
