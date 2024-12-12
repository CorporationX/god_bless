package school.faang.bjs244832;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        if (city == null || city.trim().isEmpty()) {
            logger.error("City cannot be null or empty");
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        double temperature = -40 + (80 * random.nextDouble());
        double humidity = 0 + (100 * random.nextDouble());
        long timestamp = System.currentTimeMillis();

        logger.info("Fetched weather data for city: {}", city);

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}