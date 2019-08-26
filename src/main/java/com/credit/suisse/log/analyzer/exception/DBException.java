package com.credit.suisse.log.analyzer.exception;

/*
* Custom exception for Database activities.
* Author: Harish Deore
*/

public class DBException extends Exception {
    public DBException(String message) {
        super(message);
    }
}
