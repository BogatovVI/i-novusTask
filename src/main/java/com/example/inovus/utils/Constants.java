package com.example.inovus.utils;

import java.util.ArrayList;
import java.util.List;

public final class Constants {
    public static final List<String> arraySymbol = new ArrayList<>(12);
    public static final String region;

    static {
        arraySymbol.add("A");
        arraySymbol.add("В");
        arraySymbol.add("Е");
        arraySymbol.add("К");
        arraySymbol.add("М");
        arraySymbol.add("Н");
        arraySymbol.add("О");
        arraySymbol.add("Р");
        arraySymbol.add("С");
        arraySymbol.add("Т");
        arraySymbol.add("У");
        arraySymbol.add("Х");

        region = " 116 rus";
    }
}