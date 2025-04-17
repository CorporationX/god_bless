package school.faang.cachingweather;

import lombok.Data;

@Data
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
