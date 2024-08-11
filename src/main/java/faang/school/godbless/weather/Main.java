package faang.school.godbless.weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    private static WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        // Тестирование программы
        System.out.println(getWeatherInfo("London"));
        System.out.println(getWeatherInfo("New York"));
        System.out.println(getWeatherInfo("London")); // Должно вернуть из кэша

        updateWeatherInfo("London");
        System.out.println(getWeatherInfo("London")); // Обновленные данные

        removeWeatherInfo("New York");
        System.out.println(getWeatherInfo("New York")); // Должно снова вызвать сервис

        System.out.println("Available cities in cache:");
        printCachedCities();
    }

    public static WeatherData getWeatherInfo(String city) {
        if (weatherCache.containsKey(city)) {
            System.out.println("Returning cached data for " + city);
            return weatherCache.get(city);
        } else {
            System.out.println("Fetching new data for " + city);
            WeatherData newData = weatherService.getWeather(city);
            weatherCache.put(city, newData);
            return newData;
        }
    }

    public static void updateWeatherInfo(String city) {
        System.out.println("Updating weather data for " + city);
        WeatherData newData = weatherService.getWeather(city);
        weatherCache.put(city, newData);
    }

    public static void removeWeatherInfo(String city) {
        System.out.println("Removing weather data for " + city);
        weatherCache.remove(city);
    }

    public static void printCachedCities() {
        Set<String> cities = weatherCache.keySet();
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
