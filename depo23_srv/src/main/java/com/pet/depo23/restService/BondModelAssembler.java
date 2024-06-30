package com.pet.depo23.restService;

import com.pet.depo23.controller.BondController;
import com.pet.depo23.entity.Bond;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BondModelAssembler implements RepresentationModelAssembler<Bond, EntityModel<Bond>> {
    @Override
    public EntityModel<Bond> toModel( Bond bond ) {
        return EntityModel.of( bond,
                linkTo( methodOn( BondController.class ).one( bond.getId() )).withSelfRel(),
                linkTo( methodOn( BondController.class ).all()).withRel( "bonds" ));
    }
}
