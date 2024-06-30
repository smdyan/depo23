package com.pet.depo23.restService;

public class BondNotFoundException extends RuntimeException {
    public BondNotFoundException( Long id ) {
        super( "Could not find bond " + id );
    }
}
