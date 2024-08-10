package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;

    public WeatherData(String city, double temperature, double humidity) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        if (temperature < 0 || temperature > 50) {
            throw new IllegalArgumentException("Temperature must be between 0 and 50");
        }
        if (humidity < 0 || humidity > 100) {
            throw new IllegalArgumentException("Humidity must be between 0 and 100");
        }
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
