package school.faang.task_44908;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class WeatherService implements WeatherProvider {
    private static final double MAX_TEMPERATURE = 120.0;
    private static final double MIN_TEMPERATURE = -50.0;
    private static final double MAX_HUMIDITY = 100.0;
    private static final double MIN_HUMIDITY = 20.0;

    final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public WeatherData fetchWeatherData(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank");
        }

        log.info("\nFetching weather data for city:\n{}", city);
        return new WeatherData(city, getRandomTemperature(), getRandomHumidity(), System.currentTimeMillis());
    }

    protected double getRandomTemperature() {
        return random.nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE);
    }

    protected double getRandomHumidity() {
        return random.nextDouble(MIN_HUMIDITY, MAX_HUMIDITY);
    }
}
