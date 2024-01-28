package com.arquiteturahexagonal.aplicacao.adaptatores.controllers.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}

