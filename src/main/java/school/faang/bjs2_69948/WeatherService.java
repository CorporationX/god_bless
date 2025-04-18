package school.faang.bjs2_69948;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        var temperature = random.nextDouble();
        var humidity = random.nextDouble();
        var timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}