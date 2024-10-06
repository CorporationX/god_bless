package school.faang.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class WeatherData {
    private final String city;
    private double temp;
    private double humidity;
}
