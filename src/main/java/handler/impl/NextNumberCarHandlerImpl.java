package handler.impl;

import com.example.inovus.utils.Constants;
import converter.CarNumberDtoConverter;
import handler.CarNumberHandler;
import handler.NextNumberCarHandler;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class NextNumberCarHandlerImpl implements NextNumberCarHandler {

    private final CarNumberHandler carNumberHandler;

    private final CarNumberDtoConverter carNumberDtoConverter;

    public NextNumberCarHandlerImpl(CarNumberHandler carNumberHandler, CarNumberDtoConverter carNumberDtoConverter) {
        this.carNumberHandler = carNumberHandler;
        this.carNumberDtoConverter = carNumberDtoConverter;
    }

    @Override
    public String next(Integer idUser) {

        var carNumberUser = carNumberDtoConverter.stringToCarNumberDto(carNumberHandler.searchLastUserCarNumber(idUser));
        var arrayCarNumberUser = carNumberUser.Number.split("");
        var stack = new Stack<String>();

        StringBuilder resultNumber = new StringBuilder(carNumberUser.Number);
        StringBuilder resultSymbol = new StringBuilder(carNumberUser.firstSymbol
                + carNumberUser.secondSymbol + carNumberUser.thirdSymbol);

        resultNumber.ensureCapacity(3);
        resultSymbol.ensureCapacity(3);

        if(!carNumberUser.Number.contains("000")){//Инкрементируем числа если не 000
            resultNumber.delete(0, 3);

            for(int i = 0; i < 3; i++){
                stack.push(arrayCarNumberUser[i]);
            }

            while(!stack.empty()){

                var number = stack.pop();

                var intSum = Integer.parseInt(number) + 1;

                if (intSum == 10){
                    resultNumber.append("0");
                } else {
                    resultNumber.append(intSum);
                }

            }

            resultNumber.reverse();
        } else {//Обработка инкрементации символов
            resultSymbol.delete(0, 3);

            stack.push(carNumberUser.thirdSymbol);
            stack.push(carNumberUser.secondSymbol);
            stack.push(carNumberUser.firstSymbol);

            while(!stack.empty()){
                var symbol = stack.pop();
                var indexSymbolArray = Constants.arraySymbol.indexOf(symbol);

                if (indexSymbolArray != Constants.arraySymbol.size() - 1){
                    resultSymbol.append(Constants.arraySymbol.get(indexSymbolArray + 1));
                } else {
                    resultSymbol.append(symbol);
                }
            }

            resultSymbol.reverse();
        }

        var result = resultSymbol.insert(1, resultNumber).append(carNumberUser.regionConstants).toString();

        return result;
    }

    @Override
    public String searchGenerateCarNumber(Integer idUser) {
        var resultCarNumber = next(idUser);

        if (!carNumberHandler.searchCarNumber(resultCarNumber)){
            carNumberHandler.addCarNumber(resultCarNumber, idUser);
            return resultCarNumber;
        }

        return "Next номер уже сгенерирован у пользователя!";
    }
}