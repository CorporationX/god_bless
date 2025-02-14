package school.faang.cachecache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Класс с основными данными о погоде в городе
 */
@AllArgsConstructor
@Getter
@ToString
public class WeatherData {
    @NonNull
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;


}
