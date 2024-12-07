package school.faang.task_44818;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double temperature = random.nextDouble() * 40 - 10;
        double humidity = random.nextDouble() * 100;
        long timestamp = System.currentTimeMillis();
        try {
            return new WeatherData(city, temperature, humidity, timestamp);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
