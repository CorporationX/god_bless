package school.faang.sprint1.task_BJS2_57007.data;

import java.time.Instant;
import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Random RANDOM = new Random();
    private static final double MIN_TEMPERATURE = -50D;
    private static final double MAX_TEMPERATURE = 50D;
    private static final double MIN_HUMIDITY = 50D;
    private static final double MAX_HUMIDITY = 100D;

    private long timestamp;
    private double temperature;
    private double humidity;

    @Override
    public WeatherData fetchWeatherData(String city) {
        timestamp = Instant.now().toEpochMilli();
        temperature = RANDOM.nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE);
        humidity = RANDOM.nextDouble(MIN_HUMIDITY, MAX_HUMIDITY);

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
