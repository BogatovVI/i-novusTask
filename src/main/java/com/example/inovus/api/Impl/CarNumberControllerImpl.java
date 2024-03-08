package com.example.inovus.api.Impl;

import com.example.inovus.api.CarNumberController;
import handler.GenerateCarNumber;
import handler.NextNumberCarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/number")
@RestController
public class CarNumberControllerImpl implements CarNumberController {

    @Autowired
    public GenerateCarNumber generateCarNumber;

    @Autowired
    public NextNumberCarHandler nextNumberCarHandler;

    @GetMapping("/random")
    public String getRandomCarNumber(@RequestParam Integer idUser){
        return generateCarNumber.generateNumber(idUser);
    }

    @GetMapping("/next")
    public String getNextCarNumber(@RequestParam Integer idUser){
        return nextNumberCarHandler.searchGenerateCarNumber(idUser);
    }
}