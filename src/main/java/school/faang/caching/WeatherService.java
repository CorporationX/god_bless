package school.faang.caching;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Random GENERATOR = new Random();

    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, GENERATOR.nextDouble(), GENERATOR.nextDouble(), System.currentTimeMillis());
    }
}