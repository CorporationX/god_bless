package school.faang.task_56899;

import lombok.NonNull;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final double MIN_TEMPERATURE = -30.0;
    private static final double MAX_TEMPERATURE = 30.0;
    private static final double MIN_HUMIDITY = 30.0;
    private static final double MAX_HUMIDITY = 85.0;

    @Override
    public WeatherData fetchWeatherData(@NonNull String city) {
        double temperature = Math.round(new Random().nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE) * 10.0) / 10.0;
        double humidity = Math.round(new Random().nextDouble(MIN_HUMIDITY, MAX_HUMIDITY) * 10.0) / 10.0;
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
