package school.faang.module1.bjs2_79786;

import lombok.Data;

@Data
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}