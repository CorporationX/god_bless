package school.faang.task_56899;

import lombok.NonNull;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(@NonNull String city) {
        double temperature = Math.round(new Random().nextDouble(-30, 30) * 10.0) / 10.0;
        double humidity = Math.round(new Random().nextDouble(30, 85) * 10.0) / 10.0;
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
