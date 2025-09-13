package school.faang.bjs2_86085;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();
    private static final double MIN_TEMPERATURE = -30.0;
    private static final double MAX_TEMPERATURE = 40.0;
    private static final double TEMPERATURE_RANGE = MAX_TEMPERATURE - MIN_TEMPERATURE;
    private static final double MAX_HUMIDITY = 100.0;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = MIN_TEMPERATURE + random.nextDouble() * TEMPERATURE_RANGE;
        double humidity = random.nextDouble() * MAX_HUMIDITY;
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}