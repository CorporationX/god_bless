package school.faang.sprint1.cashingweather;

import java.util.Random;

/**
 * Mock service that simulates fetching weather data
 */
public class WeatherService implements WeatherProvider {

    private static final double MIN_TEMPERATURE = -25.0;
    private static final double MAX_TEMPERATURE = 40.0;
    private static final double MIN_HUMIDITY = 0.0;
    private static final double MAX_HUMIDITY = 25.0;

    private final Random random = new Random();

    /**
     * Generates 'random' temperature and humidity values
     *
     * @param city city name
     * @return generated weather data with current timestamp
     */
    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = MIN_TEMPERATURE + (random.nextDouble() * (MAX_TEMPERATURE - MIN_TEMPERATURE));
        double humidity = MIN_HUMIDITY + (random.nextDouble() * (MAX_HUMIDITY - MIN_HUMIDITY));
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
