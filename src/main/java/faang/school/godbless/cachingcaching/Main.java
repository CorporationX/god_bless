package faang.school.godbless.cachingcaching;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    private static WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        WeatherData weatherInLondon = getWeather("London");
        System.out.println(weatherInLondon);

        updateWeather("London");

        weatherInLondon = getWeather("London");
        System.out.println(weatherInLondon);

        removeWeather("London");

        weatherInLondon = getWeather("London");
        System.out.println(weatherInLondon);

        System.out.println("Cities in cache: " + getCachedCities());
    }

    public static WeatherData getWeather(String city) {
        if (weatherCache.containsKey(city)) {
            System.out.println("Fetching weather data for " + city + " from cache.");
            return weatherCache.get(city);
        } else {
            System.out.println("Fetching weather data for " + city + " from external service.");
            WeatherData weatherData = weatherService.getWeather(city);
            weatherCache.put(city, weatherData);
            return weatherData;
        }
    }

    public static void updateWeather(String city) {
        System.out.println("Updating weather data for " + city + ".");
        WeatherData weatherData = weatherService.getWeather(city);
        weatherCache.put(city, weatherData);
    }

    public static void removeWeather(String city) {
        System.out.println("Removing weather data for " + city + " from cache.");
        weatherCache.remove(city);
    }

    public static Set<String> getCachedCities() {
        return weatherCache.keySet();
    }
}