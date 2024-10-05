package school.faang.t13;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> WEATHER_CACHE = new HashMap<>();

    public static void main(String[] args) {

        WeatherData cityWeatherLondon = new WeatherData("London", 20, 80);
        WeatherData cityWeatherMoscow = new WeatherData("Moscow", 25, 60);
        WeatherData cityWeatherParis = new WeatherData("Paris", 12, 50);

        WEATHER_CACHE.put("London", cityWeatherLondon);
        WEATHER_CACHE.put("Moscow", cityWeatherMoscow);
        WEATHER_CACHE.put("Paris", cityWeatherParis);

        getWeather("London");
        getWeather("Berlin");
        updateWeather("Moscow");
        removeWeather("Moscow");
        listCities();
    }

    public static WeatherData getWeather(String city) {
        if (WEATHER_CACHE.containsKey(city)) {
            return WEATHER_CACHE.get(city);
        } else {
            WeatherData weatherData = WeatherService.getWeatherData(city);
            WEATHER_CACHE.put(city, weatherData);
            return weatherData;
        }
    }

    public static void updateWeather(String city) {
        WeatherData weatherData = WeatherService.getWeatherData(city);
        WEATHER_CACHE.put(city, weatherData);
    }

    public static void removeWeather(String city) {
        WEATHER_CACHE.remove(city);
    }

    public static void listCities() {
        System.out.println("Cities :");
        for (String city : WEATHER_CACHE.keySet()) {
            System.out.println(city);
        }
    }
}