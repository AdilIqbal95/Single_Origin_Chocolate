package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam Optional<Integer> cocoaPercentage ) {
        List<Chocolate> chocolates;
        if (cocoaPercentage.isPresent()  && (cocoaPercentage.get() > 45)) {
            chocolates = chocolateService.getChocolatesByCocoaPercentage(cocoaPercentage.get());
        } else {
            chocolates = chocolateService.getAllChocolates();
        }
         return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id) {
        return new ResponseEntity<>(chocolateService.getChocolateById(id).get(), HttpStatus.OK);
    }



}
