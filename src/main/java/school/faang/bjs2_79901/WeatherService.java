package school.faang.bjs2_79901;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private static final Random RANDOM = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = RANDOM.nextDouble();
        double humidity = RANDOM.nextDouble();
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
