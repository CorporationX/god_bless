package school.faang.cache_cache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, -30 + (60 * random.nextDouble()),
                10 + (80 * random.nextDouble()), System.currentTimeMillis());
    }
}
