package handler.impl;

import handler.CarNumberHandler;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarNumberHandlerImpl implements CarNumberHandler {

    //Дерево номеров
    private final Set<String> carNumbers = new TreeSet<>();

    //Хочу хранить последнее значение номера автомобиля пользователя
    private final Map<Integer, String> mapUser = new HashMap<>();

    //Поиск номера
    public boolean searchCarNumber(String numberCar){
        return carNumbers.contains(numberCar);
    }

    //Добавление номера
    public void addCarNumber(String numberCar, Integer idUser){
        carNumbers.add(numberCar);
        mapUser.put(idUser, numberCar);
    }

    public String searchLastUserCarNumber(Integer idUser){
        return mapUser.get(idUser);
    }
}