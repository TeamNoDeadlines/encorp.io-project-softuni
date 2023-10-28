package com.NoDeadlines.SoftUniFestApp2023.exceptions;

public class WrongLoginCredentialsException extends RuntimeException{
    public WrongLoginCredentialsException(){
        super("Invalid login credential");
    }

}
