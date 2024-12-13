package school.faang.task_44866;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        this.city = Objects.requireNonNull(city, "City cannot be null or empty");
        if (city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }

        if (temperature < -100 || temperature > 60) {
            throw new IllegalArgumentException("Temperature must be between -100 and 60 degrees Celsius");
        }
        this.temperature = temperature;

        if (humidity < 0 || humidity > 100) {
            throw new IllegalArgumentException("Humidity must be between 0% and 100%");
        }
        this.humidity = humidity;

        if (timestamp <= 0) {
            throw new IllegalArgumentException("Timestamp must be a positive value");
        }
        this.timestamp = timestamp;
    }
}
