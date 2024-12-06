package school.faang.sprint_1.task_44835.service;

import school.faang.sprint_1.task_44835.dto.WeatherData;

import java.time.Instant;
import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        var random = new Random();
        var temperature = random.nextDouble(0, 40);
        var humidity = random.nextDouble(0, 100);
        long timestamp = Instant.now().toEpochMilli();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
