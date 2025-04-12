package school.faang.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
