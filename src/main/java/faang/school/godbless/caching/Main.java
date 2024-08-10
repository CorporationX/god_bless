package faang.school.godbless.caching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static Map<String, WeatherData> weatherDataCache = new HashMap<>();

    public static WeatherData getWeatherData(String city) {
        if (weatherDataCache.containsKey(city)) {
            return weatherDataCache.get(city);
        } else {
            weatherDataCache.put(city, Service.getWeatherData(city));
            return weatherDataCache.get(city);
        }
    }

    public static void updateWeatherData(String city, WeatherData weatherData) {
        weatherDataCache.put(city, weatherData);
    }

    public static void clearWeatherData(String city) {
        weatherDataCache.remove(city);
    }

    public static List<String> getAllCities() {
        return new ArrayList<>(weatherDataCache.keySet());
    }

    public static void main(String[] args) {
        System.out.println("get mock weather data: ");
        System.out.println(getWeatherData("The City"));

        System.out.println();

        System.out.println("update weather data and get weather data from cache:");
        updateWeatherData("The City",new WeatherData("The City", 30.0F, 75.0F));
        System.out.println(getWeatherData("The City"));

        System.out.println();

        System.out.println("get weather data from cache:");
        System.out.println(getWeatherData("The City"));

        System.out.println();

        System.out.println("add one more mock data to cache:");
        System.out.println(getWeatherData("The Mock City"));

        System.out.println();

        System.out.println("list all cities in cache:");
        System.out.println(getAllCities());

        System.out.println();

        System.out.println("remove city (the city) from cache and print all cities:");
        clearWeatherData("The City");
        System.out.println(getAllCities());
    }

}
