package school.faang.task_44825;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        if (city == null) {
            throw new IllegalArgumentException("City doesn't exist");
        }
        Random random = new Random();
        return new WeatherData(city, random.nextDouble(), random.nextDouble(), System.currentTimeMillis());
    }
}