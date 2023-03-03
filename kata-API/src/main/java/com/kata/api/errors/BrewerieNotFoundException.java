package com.kata.api.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BrewerieNotFoundException extends RuntimeException {

    private static final  long serialVersionUID = 43876691117760211L;

    public BrewerieNotFoundException(Long id){
        super("No se puede encontrar la cerveceria con la ID: " + id);

    }
}
