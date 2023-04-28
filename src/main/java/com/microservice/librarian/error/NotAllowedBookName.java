package com.microservice.librarian.error;

public class NotAllowedBookName extends Exception{

    public NotAllowedBookName() {
        super("Name not allowed");
    }
}
