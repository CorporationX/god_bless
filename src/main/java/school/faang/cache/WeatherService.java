package school.faang.cache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, random.nextDouble(-30, 30), random.nextDouble(50, 100),
                System.currentTimeMillis());
    }
}