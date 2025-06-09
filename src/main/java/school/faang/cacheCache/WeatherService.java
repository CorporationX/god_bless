package school.faang.cacheCache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double temperature = random.nextDouble(35);
        double humidity = random.nextDouble(80 - 50 + 1) + 50;
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }


}
