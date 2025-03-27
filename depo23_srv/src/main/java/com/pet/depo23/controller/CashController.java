package com.pet.depo23.controller;

import java.util.*;
import com.pet.depo23.entity.Cash;
import com.pet.depo23.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CashController {
    @Autowired
    private CashRepository cashRepository;
    
    private CashController( CashRepository cashRepository ){
        this.cashRepository = cashRepository;
    }
    @GetMapping("/cash")
    public List<Cash> fetchCashes() {
        return cashRepository.findAll();
    }
    
}
