package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Estate estateAdil = new Estate("Adil", "Switzerland");
        Estate estateGhish = new Estate("Ghish", "Belgium");

        estateService.saveEstate(estateAdil);
        estateService.saveEstate(estateGhish);

        Chocolate cadbury = new Chocolate("Cadbury", 30, estateGhish);
        Chocolate lindt = new Chocolate("Lindt", 70, estateAdil);
        Chocolate kinder = new Chocolate("Kinder", 50, estateGhish);
        Chocolate maltesers = new Chocolate("Maltesers", 40, estateAdil);

        chocolateService.saveChocolate(cadbury);
        chocolateService.saveChocolate(lindt);
        chocolateService.saveChocolate(kinder);
        chocolateService.saveChocolate(maltesers);



    }

}
