package school.faang.weather;

import java.util.Random;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
public class WeatherService implements WeatherProvider {

    private static final Random RANDOM = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        var temperature = RANDOM.nextDouble();
        var humidity = RANDOM.nextDouble();
        var timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
