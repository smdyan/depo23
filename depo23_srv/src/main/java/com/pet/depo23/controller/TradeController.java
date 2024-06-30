package com.pet.depo23.controller;

import java.util.*;
import com.pet.depo23.entity.Trade;
import com.pet.depo23.repository.TradeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trades")
public class TradeController {
    private final TradeRepository tradeRepository;
    //@Autowired
    public TradeController( TradeRepository tradeRepository ){
        this.tradeRepository = tradeRepository;
    }
    @GetMapping
    public String showList( Model model ){
        List<Trade> trades = new ArrayList<Trade>();
        trades.addAll( tradeRepository.findAll( ));
        model.addAttribute("trades", trades);
        return "trade-index";
    }
    @GetMapping("/new")
    public String showFillForm( Model model ){
        Trade trade = new Trade();
        trade.setTradeType("buy");
        model.addAttribute("trade", trade);
        model.addAttribute("title", "New trade operation");
        return "trade-form";
    }
    @PostMapping("/save")
    public String saveTrade(@ModelAttribute Trade trade){
        System.out.println( "save id " + trade.getId( ));
        tradeRepository.save( trade );
        return "redirect:/trades";
    }
    @GetMapping("/edit/{id}")
    public String editTrade( @PathVariable("id") Long id, Model model ){
        Trade trade = tradeRepository.getReferenceById( id );
        model.addAttribute("trade", trade);
        model.addAttribute("title", "Edit trade operation id:" + trade.getId());
        return "trade-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteTrade( @PathVariable("id") Long id, Model model ){
        tradeRepository.deleteById( id );
        return "redirect:/trades";
    }
}