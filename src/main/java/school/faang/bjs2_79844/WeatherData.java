package school.faang.bjs2_79844;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    double humidity;
    long timestamp;
}
