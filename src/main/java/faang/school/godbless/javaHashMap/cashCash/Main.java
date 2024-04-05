package faang.school.godbless.javaHashMap.cashCash;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherDataCache;
    private static OuterService outerService;


    public static void main(String[] args) {
        weatherDataCache = new HashMap<>();
        outerService = new OuterService();

        weatherDataCache.put("London", new WeatherData("London", 15, 75));
        weatherDataCache.put("New York", new WeatherData("New York", 20, 65));
        weatherDataCache.put("Paris", new WeatherData("Paris", 18, 80));
        weatherDataCache.put("Tokyo", new WeatherData("Tokyo", 22, 70));
        weatherDataCache.put("Sydney", new WeatherData("Sydney", 25, 60));
        weatherDataCache.put("Moscow", new WeatherData("Moscow", 10, 85));
        weatherDataCache.put("Berlin", new WeatherData("Berlin", 16, 78));
        weatherDataCache.put("Rome", new WeatherData("Rome", 21, 72));
        weatherDataCache.put("Los Angeles", new WeatherData("Los Angeles", 24, 55));
        weatherDataCache.put("Beijing", new WeatherData("Beijing", 19, 68));


        System.out.println("Weather data manager check.\n");

        System.out.println("Cache state at start point:");
        weatherDataCache.values().forEach(System.out::println);


        System.out.println("\n\nGetting weather data for Moscow (contains in cache):");
        System.out.println(getWeatherDataForCity("Moscow"));

        System.out.println("\nGetting weather data for Saint-Petersburg (!contains in cache):");
        System.out.println(getWeatherDataForCity("Saint-Petersburg"));

        System.out.println("\nCache state at this point:");
        weatherDataCache.values().forEach(System.out::println);


        System.out.println("\n\nUpdating weather data for Moscow (contains in cache):");
        System.out.println(updateWeatherData("Moscow"));

        System.out.println("\nUpdating weather data for Vienna (contains in cache):");
        System.out.println(updateWeatherData("Vienna"));

        System.out.println("\nCache state at this point:");
        weatherDataCache.values().forEach(System.out::println);


        System.out.println("\n\nRemoving weather data for Moscow (contains in cache):");
        removeCityWeatherData("Moscow");

        System.out.println("\nCache state at this point:");
        weatherDataCache.values().forEach(System.out::println);


        System.out.println("\n\nList of cities whose weather data is stored in the cache:");
        printCitiesFromCache();
    }

    public static WeatherData getWeatherDataForCity(String city) {
        return weatherDataCache.computeIfAbsent(city, key -> outerService.getWeatherData(key));
    }

    public static WeatherData updateWeatherData(String city) {
        weatherDataCache.put(city, outerService.getWeatherData(city));
        return weatherDataCache.get(city);
    }

    public static void removeCityWeatherData(String city) {
        weatherDataCache.remove(city);
    }

    public static void printCitiesFromCache() {
        weatherDataCache.keySet().forEach(System.out::println);
    }
}
