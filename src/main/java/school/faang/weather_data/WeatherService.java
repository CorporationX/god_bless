package school.faang.weather_data;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(
                city,
                -20 + 40 * random.nextDouble(),
                100 * random.nextDouble(),
                System.currentTimeMillis()
        );
    }
}