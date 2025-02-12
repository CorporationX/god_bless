package school.faang.task_57024;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final double MIN_TEMPERATURE = -20.0;
    private static final double MAX_TEMPERATURE = 40.0;
    private static final double MIN_HUMIDITY = 20.0;
    private static final double MAX_HUMIDITY = 100.0;

    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
        double humidity = MIN_HUMIDITY + (MAX_HUMIDITY - MIN_HUMIDITY) * random.nextDouble();
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
