package com.pet.depo23.restService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class BondNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler( BondNotFoundException.class )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    String bondNotFoundHandler( BondNotFoundException ex ) {
        return ex.getMessage();
    }
}
