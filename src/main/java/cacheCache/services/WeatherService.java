package cacheCache.services;

import cacheCache.WeatherData;

import java.util.Random;

public class WeatherService {

    public static WeatherData getWeatherData(String city) {
        return new WeatherData(city, new Random().nextInt(-100, 100), new Random().nextInt(100));
    }
}
