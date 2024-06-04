package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    public List<Chocolate> getAllChocolates(){ return chocolateRepository.findAll();}

    public Optional<Chocolate> getChocolateById(long id){ return chocolateRepository.findById(id);}

    public Chocolate saveChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }

//    public List<Chocolate> filterChocolateByEstate(Estate estate) {
//        List<Chocolate> ghishChocolates = new ArrayList<>();
//        List<Chocolate> adilChocolates = new ArrayList<>();
//
//        for (Chocolate chocolate : this.getAllChocolates()) {
//            if (chocolate.getEstate().equals("estateGhish")) {
//                ghishChocolates.add(chocolate);
//            } else if (chocolate.getEstate().equals("estateAdil")) {
//                adilChocolates.add(chocolate);
//            }
//        } return

}
