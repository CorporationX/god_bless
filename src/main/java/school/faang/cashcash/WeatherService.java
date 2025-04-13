package school.faang.cashcash;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = new Random().nextDouble(-30, 60);
        double humidity = new Random().nextDouble(0, 100);
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
