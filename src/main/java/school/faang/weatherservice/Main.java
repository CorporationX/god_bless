package school.faang.weatherservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Create a HashMap to act as a cache for weather data
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();
    private static final WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        // Add some initial data
        updateWeatherData("Winterfell", 2.5, 85);
        updateWeatherData("King's Landing", 25.0, 50);

        // Test various functionalities
        getWeather("Winterfell");
        getWeather("Dragonstone");
        printAllCities();

        // Update weather data for a city
        updateWeatherData("Dragonstone", 10.5, 60);
        getWeather("Dragonstone");

        // Remove weather data for a city
        removeWeatherData("Winterfell");
        System.out.println("\nAfter removing Winterfell:");
        printAllCities();

        // User interaction for dynamic testing
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a city to get its weather:");
        String city = scanner.nextLine();
        getWeather(city);
    }
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

    // Method to remove weather data from the cache by city name
    public static void removeWeatherData(String city) {
        weatherCache.remove(city);
        System.out.println("Removed weather data for " + city);
    }

    // Method to print all cities currently in the cache
    public static void printAllCities() {
        System.out.println("All cities in cache:");
        for (String city : weatherCache.keySet()) {
            System.out.println(city);
        }
    }


}