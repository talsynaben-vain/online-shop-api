package com.example.onlineshopapi.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Integer id) {
        super("Item with id " + id + " not found");
    }
}
