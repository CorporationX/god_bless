package cacheCache;

import java.util.Random;

public class Weather {

    public static WeatherData getWeatherData(String city) {
        return new WeatherData(city,
                new Random().nextInt(-50, 50),
                new Random().nextInt(0, 100));
    }
}
