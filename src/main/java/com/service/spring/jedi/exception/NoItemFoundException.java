package com.service.spring.jedi.exception;

public class NoItemFoundException extends Exception {
    public NoItemFoundException() {
        super("Item is not found!");
    }
}
