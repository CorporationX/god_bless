package faang.school.godbless.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, WeatherData> cache;

    public static void main(String[] args) {

        cache = new HashMap<>();
        cache.put("London", new WeatherData("London", 20, 70));
        cache.put("Madrid", new WeatherData("Madrid", 31, 80));

        System.out.println("Weather from outside service");
        System.out.println(getweather("Moscow"));
        System.out.println();
        updateWeatherCache("Moscow");
        for (String city : getCitiesWithWeatherCache()) {
            System.out.println(city);
        }
        removeWeatherCache("Moscow");
        System.out.println("After delete Moscow");
        for (String city : getCitiesWithWeatherCache()) {
            System.out.println(city);
        }
    }

    private static List<String> getCitiesWithWeatherCache() {
        List<String> cities = new ArrayList<>();
        for (Map.Entry<String, WeatherData> weather : cache.entrySet()) {
            cities.add(weather.getKey());
        }
        return cities;
    }

    private static void removeWeatherCache(String city) {
        cache.remove(city);
    }

    private static void updateWeatherCache(String city) {
        cache.put(city, WeatherServer.getWeatherData(city));
    }

    private static WeatherData getweather(String city) {
        if (cache.get(city) != null) {
            return cache.get(city);
        }
        cache.put(city, WeatherServer.getWeatherData(city));
        return cache.get(city);
    }
}
