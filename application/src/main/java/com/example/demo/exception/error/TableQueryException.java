package com.example.demo.exception.error;

public class TableQueryException extends RuntimeException {

    public TableQueryException() {
        super("Query failed");
    }
}
