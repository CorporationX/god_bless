package hashmap.cashing;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<String, WeatherData> WEATHER_CACHE = new HashMap<>();

    public static void main(String[] args) {
        WEATHER_CACHE.put("NY", WeatherService.getWeather("NY"));
        WEATHER_CACHE.put("Moscow", WeatherService.getWeather("Moscow"));
        WEATHER_CACHE.put("Amsterdam", WeatherService.getWeather("Amsterdam"));
        printCache();
        System.out.println(getWeather("NY"));
        System.out.println(getWeather("Yakutsk"));
        printCache();
        removeDataFromCache("Yakutsk");
        removeDataFromCache("London");
        printCache();
        updateCache("Moscow");
        printCache();
        clearCache();
        printCache();
    }

    public static WeatherData getWeather(@NonNull String city) {
        if (!WEATHER_CACHE.containsKey(city)) {
            WeatherData weatherData = WeatherService.getWeather(city);
            WEATHER_CACHE.put(city, weatherData);
        }
        return WEATHER_CACHE.get(city);
    }

    public static void updateCache(@NonNull String city) {
        System.out.println("\nUpdated cache for " + city);
        WEATHER_CACHE.put(city, WeatherService.getWeather(city));
    }

    public static void removeDataFromCache(@NonNull String city) {
        if (WEATHER_CACHE.containsKey(city)) {
            System.out.println("\nNo data for this city in cache");
        }
        WEATHER_CACHE.remove(city);
    }

    public static void printCache() {
        if (WEATHER_CACHE == null || WEATHER_CACHE.isEmpty()) {
            System.out.println("\nCache is empty or null");
        } else {
            System.out.println("\nCurrent cache:");
            WEATHER_CACHE.forEach((k, v) -> System.out.println(k + " : " + v));
        }
    }

    public static void clearCache() {
        System.out.println("\nCache is cleared");
        WEATHER_CACHE.clear();
    }
}
