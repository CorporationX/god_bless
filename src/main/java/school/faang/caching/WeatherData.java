package school.faang.caching;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String cityName;
    private double temperature;
    private double humidity;
}
