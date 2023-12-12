package CacheCacheWeather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherCityCache = new HashMap<>();

    public static void main(String[] args) {
        Main.findOutTheWeather("London");
        Main.findOutTheWeather("Moscow");
        Main.findOutTheWeather("London");

        Main.updateWeatherCache("London");
        Main.findOutTheWeather("London");

        System.out.println(Main.showAllCityesWithCache());
        Main.removeWeatherCache("London");
        System.out.println(Main.showAllCityesWithCache());
    }

    public static void findOutTheWeather(String city) {
        if (!weatherCityCache.containsKey(city)) {
            Main.updateWeatherCache(city);
        }
        System.out.println(weatherCityCache.get(city));
    }

    public static void updateWeatherCache(String city) {
        weatherCityCache.put(city, MeteoStation.getWeather(city));
    }

    public static void removeWeatherCache(String city) {
        weatherCityCache.remove(city);
    }

    public static List<String> showAllCityesWithCache() {
        List<String> findedCities = new ArrayList<>();
        weatherCityCache.forEach((city, weather) -> findedCities.add(city));
        return findedCities;
    }
}
