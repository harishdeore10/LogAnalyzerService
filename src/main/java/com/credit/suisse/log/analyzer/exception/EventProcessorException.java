package com.credit.suisse.log.analyzer.exception;

/*
 * Custom exception for Event processing activities.
 * Author: Harish Deore
 */

public class EventProcessorException extends Exception {
    public EventProcessorException(String message) {
        super(message);
    }
}
