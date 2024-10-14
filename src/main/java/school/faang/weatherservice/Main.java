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

    // Method to update weather data in the cache for a specific city
    public static void updateWeatherData(String city, double temperature, int humidity) {
        WeatherData newWeatherData = new WeatherData(city, temperature, humidity);
        weatherCache.put(city, newWeatherData);
        System.out.println("Updated weather for " + city + ": " + newWeatherData);
    }

}