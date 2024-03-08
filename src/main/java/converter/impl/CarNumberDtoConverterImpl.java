package converter.impl;

import com.example.inovus.dto.CarNumberDto;
import converter.CarNumberDtoConverter;
import org.springframework.stereotype.Service;

@Service
public class CarNumberDtoConverterImpl implements CarNumberDtoConverter {
    @Override
    public CarNumberDto stringToCarNumberDto(String carNumberString) {

        var arrayCarNumberString = carNumberString.split("");

        //Можно красивее
        var arrayNumberCar = arrayCarNumberString[1] + arrayCarNumberString[2] + arrayCarNumberString[3];

        return new CarNumberDto(arrayCarNumberString[0], arrayNumberCar,
                arrayCarNumberString[4], arrayCarNumberString[5]);
    }
}