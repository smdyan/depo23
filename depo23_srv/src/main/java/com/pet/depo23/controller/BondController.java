package com.pet.depo23.controller;

import com.pet.depo23.entity.Bond;
import com.pet.depo23.restService.BondModelAssembler;
import com.pet.depo23.restService.BondNotFoundException;

//import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.pet.depo23.repository.BondRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/bonds")
@CrossOrigin("http://localhost:8081/")
public class BondController { //Bean will be registered in app context
    private final BondRepository repository; //Injection
    private final BondModelAssembler assembler;

    BondController( BondRepository repository, BondModelAssembler assembler ) {
        this.repository = repository;
        this.assembler = assembler;
    }
    @GetMapping
    public CollectionModel<EntityModel<Bond>> all() {
        List<EntityModel<Bond>> bonds = repository.findAll().stream()
                .map( assembler::toModel )
                .collect(Collectors.toList());

        return CollectionModel.of( bonds,
                linkTo( methodOn( BondController.class ).all()).withSelfRel());
    }

    @PostMapping //Consume JSON
    ResponseEntity<?> newBond(@RequestBody Bond newBond ) {
        EntityModel<Bond> entityModel = assembler.toModel( repository.save( newBond ));

        return ResponseEntity
                .created( entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body( entityModel );
    }

    @GetMapping( "/{id}" )
    public EntityModel<Bond> one(@PathVariable Long id ) {
        Bond bond = repository.findById( id )
                .orElseThrow(() -> new BondNotFoundException( id ));

        return assembler.toModel( bond );
    }

    @PutMapping( "/{id}" ) // update entity
    ResponseEntity<?> replaceBond( @RequestBody Bond newBond, @PathVariable Long id ) {
        Bond updatedBond = repository.findById( id )
                .map( bond -> {
                    bond.setName( newBond.getName( ));
                    bond.setIsin( newBond.getIsin( ));
                    return repository.save( bond );
                })
                .orElseGet( ()-> {
                    newBond.setId( id );
                    return repository.save( newBond );
                });
        EntityModel<Bond> entityModel = assembler.toModel( updatedBond ); //wrapping
        return ResponseEntity
                .created( entityModel.getRequiredLink( IanaLinkRelations.SELF ).toUri())
                .body( entityModel );
    }

    @DeleteMapping( "/{id}" )
    ResponseEntity<?> deleteBond( @PathVariable Long id ) {
        repository.deleteById( id );
        return ResponseEntity.noContent().build();
    }
}