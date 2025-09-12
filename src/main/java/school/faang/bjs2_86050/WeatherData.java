package school.faang.bjs2_86050;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
