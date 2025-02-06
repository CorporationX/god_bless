package school.faang.sprint.first.cachingcaching.service;

import school.faang.sprint.first.cachingcaching.model.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, random(1, 30), random(20, 99), System.currentTimeMillis());
    }

    private double random(int min, int max) {
        return (double) Math.round(min + (max - min) * new Random().nextDouble() * 10) / 10;
    }
}
