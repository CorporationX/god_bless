package school.faang;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData feachWeatherData(String city) {
        Random random = new Random();
        double temperature = -50 + (30 * random.nextDouble());
        double humidity = 40 + (60 * random.nextDouble());
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
