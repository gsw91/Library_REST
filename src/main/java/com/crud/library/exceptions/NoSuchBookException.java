package com.crud.library.exceptions;

public class NoSuchBookException extends Exception {

    public NoSuchBookException(String message){
        super(message);
    }
}
