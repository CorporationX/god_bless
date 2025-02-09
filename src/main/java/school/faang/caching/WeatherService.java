package school.faang.caching;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = new Random().nextDouble(-35, 35);
        double humidity = new Random().nextDouble();
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
