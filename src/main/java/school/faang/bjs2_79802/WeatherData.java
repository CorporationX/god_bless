package school.faang.bjs2_79802;

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
