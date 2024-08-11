package faang.school.godbless.cache.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<String, WeatherData> cityWeatherCache = new HashMap<>();

    public static void main(String[] args) {
        getWeather("London");
        getWeather("Moscow");
        getWeather("Kazan");

        printAllCities();
    }

    public static WeatherData getWeather(String city) {
        cityWeatherCache.computeIfAbsent(city, Gismeteo::getWeather);
        return cityWeatherCache.get(city);
    }

    public static void update(WeatherData weatherData) {
        cityWeatherCache.put(weatherData.getCity(), weatherData);
    }

    public static void delete(String city) {
        cityWeatherCache.remove(city);
    }

    private static void printAllCities() {
        cityWeatherCache.keySet().forEach(System.out::println);
    }


}
