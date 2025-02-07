package school.faang.sprint.first.cachingcaching.service;

import lombok.NonNull;
import school.faang.sprint.first.cachingcaching.model.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final int MIN_TEMPERATURE = 1;
    private static final int MAX_TEMPERATURE = 30;
    private static final int MIN_HUMIDITY = 20;
    private static final int MAX_HUMIDITY = 99;

    @Override
    public WeatherData fetchWeatherData(@NonNull String city) {
        return new WeatherData(
                city,
                random(MIN_TEMPERATURE, MAX_TEMPERATURE),
                random(MIN_HUMIDITY, MAX_HUMIDITY),
                System.currentTimeMillis());
    }

    private double random(int min, int max) {
        return (double) Math.round(min + (max - min) * new Random().nextDouble() * 10) / 10;
    }
}
