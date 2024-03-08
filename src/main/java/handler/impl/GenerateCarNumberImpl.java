package handler.impl;

import com.example.inovus.dto.CarNumberDto;
import com.example.inovus.utils.Constants;
import handler.GenerateCarNumber;
import handler.CarNumberHandler;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateCarNumberImpl implements GenerateCarNumber {

    //Для генерации псевдослучайных чисел
    private final Random randomForGenerate = new Random();

    private final CarNumberHandler carNumberHandler;

    private CarNumberDto carNumber;

    public GenerateCarNumberImpl(CarNumberHandlerImpl carNumberHandler) {
        this.carNumberHandler = carNumberHandler;

        this.carNumber = new CarNumberDto(Constants.arraySymbol.get(randomForGenerate.nextInt(11)),
                generateIntegerArrayNumber(),
                Constants.arraySymbol.get(randomForGenerate.nextInt(11)),
                Constants.arraySymbol.get(randomForGenerate.nextInt(11))
        );
    }

    @Override
    public String generateNumber(Integer idUser) {
        var flagForLoop = 0;

        //Не лучшее решение, множество свободных номер закончится и мы будет в бесконечном цикле
        while(!carNumberHandler.searchCarNumber(carNumber.toString())){
            if(flagForLoop > 15){
                break;
            }
            flagForLoop++;
            carNumber = new CarNumberDto(Constants.arraySymbol.get(randomForGenerate.nextInt(11)),
                    generateIntegerArrayNumber(),
                    Constants.arraySymbol.get(randomForGenerate.nextInt(11)),
                    Constants.arraySymbol.get(randomForGenerate.nextInt(11)));
        }

        carNumberHandler.addCarNumber(carNumber.toString(), idUser);
        return carNumber.toString();
    }

    @Override
    public String generateIntegerArrayNumber() {

        Integer[] arrayNumberInteger = new Integer[3];
        for(int i = 0; i < 3; i++){
            arrayNumberInteger[i] = randomForGenerate.nextInt(999) + 1;
        }

        String result = arrayNumberInteger[0].toString()
                + arrayNumberInteger[1].toString()
                + arrayNumberInteger[2].toString();

        return result;
    }
}