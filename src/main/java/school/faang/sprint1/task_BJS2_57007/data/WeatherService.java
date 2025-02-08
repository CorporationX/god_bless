package school.faang.sprint1.task_BJS2_57007.data;

import java.time.Instant;
import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Random RandomWeatherProvide = new Random();
    private static final double MIN_TEMPERATURE = -50D;
    private static final double MAX_TEMPERATURE = 50D;
    private static final double MIN_HUMIDITY = 50D;
    private static final double MAX_HUMIDITY = 100D;

    private double temperature;
    private double humidity;

    @Override
    public WeatherData fetchWeatherData(String city) {
        temperature = RandomWeatherProvide.nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE);
        humidity = RandomWeatherProvide.nextDouble(MIN_HUMIDITY, MAX_HUMIDITY);

        return new WeatherData(city, temperature, humidity, Instant.now().toEpochMilli());
    }
}
