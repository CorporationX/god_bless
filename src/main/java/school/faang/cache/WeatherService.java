package school.faang.cache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -50 + 100 * random.nextDouble();
        double humidity = 20 + 80 * random.nextDouble();

        return new WeatherData(city, temperature, humidity);
    }
}
