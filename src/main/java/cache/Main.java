package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static cache.ExternalService.fillWeather;

public class Main {
    private static Map<String, WeatherData> weather = new HashMap<>();

    public static void main(String[] args) {
        weather.put("Moscow", new WeatherData("Moscow", 23, 70));
        weather.put("London", new WeatherData("London", 18, 85));

        System.out.println("Weather information in the city: " + getWeather("Moscow"));
        getWeather("Baku");  //not in cache
        updateCacheCity("Moscow");  // update info exist cash
        getWeather("Moscow");
        removeCache("London");
        getAllCache();

    }

    public static WeatherData getWeather(String city) {
        if (!weather.containsKey(city)) {
            fillWeather(city,weather);
        }
        return weather.get(city);
    }

    public static void updateCacheCity(String city) {
        fillWeather(city,weather);
    }

    public static void removeCache(String city) {
        weather.remove(city);
    }

    public static void getAllCache() {
        System.out.println("\n" + "All information about weather:");
        for (Map.Entry entry : weather.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}