package school.faang;

import lombok.Getter;

@Getter
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final double timestamp;

    private void validateCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City can't be null or empty");
        }
    }

    private void validateHumidity(double humidity) {
        if (humidity < 0 || humidity > 100) {
            throw new IllegalArgumentException("Humidity must be in range [0, 100]");
        }
    }

    private void validateTemperature(double temperature) {
        if (temperature < -60 || temperature > 60) {
            throw new IllegalArgumentException("Temperature must be in range [60, 60]");
        }
    }

    public WeatherData(String city, double timestamp, double humidity, double temperature) {
        validateCity(city);
        validateHumidity(humidity);
        validateTemperature(temperature);
        this.city = city;
        this.timestamp = timestamp;
        this.humidity = humidity;
        this.temperature = temperature;
    }
}
