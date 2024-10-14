package school.faang.weatherservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Create a HashMap to act as a cache for weather data
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();
    private static final WeatherService weatherService = new WeatherService();

    // Method to get weather data for a city, using cache
    public static WeatherData getWeather(String city) {
        WeatherData weatherData = weatherCache.get(city);
        if (weatherData != null) {
            System.out.println("Weather for " + city + " (from cache): " + weatherData);
            return weatherData;
        } else {
            System.out.println("Fetching weather for " + city + " from external source...");
            weatherData = weatherService.fetchWeatherFromExternalSource(city);
            weatherCache.put(city, weatherData);
            System.out.println("Weather for " + city + ": " + weatherData);
            return weatherData;
        }
    }

}