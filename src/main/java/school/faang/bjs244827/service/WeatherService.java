package school.faang.bjs244827.service;

import school.faang.bjs244827.model.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temp = random.nextDouble(-10, 50);
        double humidity = random.nextDouble(-10, 50);
        return new WeatherData(city, temp, humidity, System.currentTimeMillis());
    }
}
