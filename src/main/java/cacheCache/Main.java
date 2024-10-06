package cacheCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Main {
    private static final Map<String, WeatherData> CITY_WEATHER_DATA = new HashMap<>();

    public static void main(String[] args) {
        CITY_WEATHER_DATA.put("London", new WeatherData("London", 20, 50));

        WeatherData weatherData = getWeatherData("Moscow");
        if (weatherData != null) {
            System.out.println(weatherData);
        }
    }

    public static WeatherData getWeatherData(String city) {
        if (!CITY_WEATHER_DATA.containsKey(city)) {
            CITY_WEATHER_DATA.computeIfAbsent(city, k -> updateWeatherData(city));
        }
        return CITY_WEATHER_DATA.get(city);
    }

    private static WeatherData updateWeatherData(String city) {
        return
    }

}
