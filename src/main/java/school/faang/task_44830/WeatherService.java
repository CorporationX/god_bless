package school.faang.task_44830;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        if (StringUtils.isBlank(city)) {
            throw new IllegalArgumentException("City is invalid!");
        }
        double temperature = new Random().nextDouble() * 50 - 20;
        double humidity = new Random().nextDouble() * 100;
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}