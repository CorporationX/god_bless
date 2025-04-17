package school.faang.weathercache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -20 + 40 * random.nextDouble();
        double humidity = 30 + 70 * random.nextDouble();

        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }
}
