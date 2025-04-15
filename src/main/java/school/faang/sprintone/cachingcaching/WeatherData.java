package school.faang.sprintone.cachingcaching;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
