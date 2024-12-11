package school.faang.s13task44826;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(City city) {
        double temperature = random.nextDouble() * 120 - 60;
        double humidity = random.nextDouble() * 100;
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}