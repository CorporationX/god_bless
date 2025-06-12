package school.faang.caching;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private final String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}