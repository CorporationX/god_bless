package ru.kraiush.BJS2_32537;

import java.util.Random;

public class Database {

    public static WeatherData getWeatherData(String city) {
        return new WeatherData(city,
                new Random().nextInt(-10, 40),
                new Random().nextInt(0, 100));
    }
}
