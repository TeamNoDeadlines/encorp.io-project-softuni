package com.NoDeadlines.SoftUniFestApp2023.exceptions;

public class ForbiddenActionException extends RuntimeException{
    public ForbiddenActionException(String msg) {
        super(msg);
    }
}
