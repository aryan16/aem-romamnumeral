package com.aem.dev.exception;

/**
 * main exception class to handle all the exceptions in the service
 */
public class MainAppException extends Exception{

    public MainAppException(final String message) {
        super(message);
    }
}
