package school.faang.bjs2_56865;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        long timestamp = System.currentTimeMillis();
        double temperature = random.nextDouble() * 45 - 10;
        double humidity = random.nextDouble() * 80 + 20;
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
