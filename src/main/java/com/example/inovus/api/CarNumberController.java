package com.example.inovus.api;

import org.springframework.web.bind.annotation.RequestParam;

public interface CarNumberController {
    String getRandomCarNumber(@RequestParam Integer idUser);

    String getNextCarNumber(@RequestParam Integer idUser);
}