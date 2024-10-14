package school.faang.weatherservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;         // City name
    private double temperature;  // Temperature in Celsius
    private int humidity;        // Humidity percentage
}