package school.faang.sprint1.task_56876;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();
    private static final double MIN_TEMPERATURE = -20;
    private static final double MAX_TEMPERATURE = 20;
    private static final double MIN_HUMIDITY = 45;
    private static final double MAX_HUMIDITY = 20;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
        double humidity = MIN_HUMIDITY + (MAX_HUMIDITY - MIN_HUMIDITY) * random.nextDouble();
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
