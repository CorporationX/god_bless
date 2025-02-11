package school.faang.caching_caching.BJS2_56894;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);

    @Override
    public WeatherData fetchWeatherData(String city) {
        if (city == null || city.isBlank()) {
            LOGGER.error("{} is null or empty", city);
            throw new IllegalArgumentException("City name cannot be null or blank");
        }

        double temperature = new Random().nextDouble(-89.2, 170);
        if (temperature < -89.2 || temperature > 170) {
            LOGGER.error("{} is out of range", temperature);
            throw new IllegalStateException("Temperature is out of valid range: " + temperature);
        }

        double humidity = new Random().nextDouble(0, 100);
        if (humidity < 0 || humidity > 100) {
            LOGGER.error("{} is out of range", humidity);
            throw new IllegalStateException("Humidity is out of valid range: " + humidity);
        }

        long timestamp = System.currentTimeMillis();
        if (timestamp <= 0) {
            LOGGER.error("{} below zero", timestamp);
            throw new IllegalStateException("Timestamp must be greater than zero");
        }

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
