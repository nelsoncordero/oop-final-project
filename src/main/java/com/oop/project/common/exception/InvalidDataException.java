package com.oop.project.common.exception;

/**
 * @author HP
 * @version 1.1
 */
public class InvalidDataException extends Exception {
    private static final String GENERAL_MESSAGE = "Invalid Parameter.";
    private static final String  FIELD_MESSAGE = "Invalid value = %s, field = %s";

    public InvalidDataException() {
        super(GENERAL_MESSAGE);
    }

    public InvalidDataException(String currentMessage) {
        super(currentMessage);
    }

    public InvalidDataException(Throwable ex) {
        super(GENERAL_MESSAGE, ex);
    }

    public InvalidDataException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }

    public InvalidDataException(String field, String value) {
        super(String.format(FIELD_MESSAGE, value, field));
    }
}
