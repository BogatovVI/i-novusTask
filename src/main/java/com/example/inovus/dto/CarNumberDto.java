package com.example.inovus.dto;

import com.example.inovus.utils.Constants;

/*
    Формат номера машины
*/
public class CarNumberDto {
    public String firstSymbol;
    public String Number;
    public String secondSymbol;
    public String thirdSymbol;
    public final String regionConstants = Constants.region;

    public CarNumberDto(String firstSymbol, String number, String secondSymbol, String thirdSymbol) {
        this.firstSymbol = firstSymbol;
        this.Number = number;
        this.secondSymbol = secondSymbol;
        this.thirdSymbol = thirdSymbol;
    }

    @Override
    public String toString() {
        return firstSymbol + Number + secondSymbol + thirdSymbol;
    }
}