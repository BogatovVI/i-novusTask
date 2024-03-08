package converter;

import com.example.inovus.dto.CarNumberDto;

public interface CarNumberDtoConverter {
    CarNumberDto stringToCarNumberDto(String carNumberString);
}