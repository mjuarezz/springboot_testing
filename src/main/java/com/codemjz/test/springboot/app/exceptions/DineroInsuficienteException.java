package com.codemjz.test.springboot.app.exceptions;

public class DineroInsuficienteException extends RuntimeException {
    /**
     *
     * @param message
     */
    public DineroInsuficienteException(final String message) {
        super(message);
    }
}
