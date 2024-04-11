package faang.school.godbless.caching_caching;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final Map<String, WeatherData> WEATHER_FORECAST_CACH = new HashMap<>();

    public static void main(String[] args) {
        WEATHER_FORECAST_CACH.put("Omsk", new WeatherData("Omsk", 15, 55));
        WEATHER_FORECAST_CACH.put("Kirov", new WeatherData("Kirov", 10, 64));
        WEATHER_FORECAST_CACH.put("Moscow", new WeatherData("Moscow", 23, 69));

        System.out.println(WEATHER_FORECAST_CACH);
        printAllCity();
        System.out.println(WEATHER_FORECAST_CACH);
    }

    public static WeatherData getInfoWeatherByCity(String city) {
        if (!WEATHER_FORECAST_CACH.containsKey(city)) {
            WEATHER_FORECAST_CACH.put(city, serviceWeather(city));
        }
        return WEATHER_FORECAST_CACH.get(city);
    }

    public static WeatherData serviceWeather(String city) {
        return new WeatherData(city, ThreadLocalRandom.current().nextInt(15, 30),
                ThreadLocalRandom.current().nextInt(55, 75));
    }

    public static void updateInfoWeatherByCity(String city, WeatherData weatherData) {
        if (!WEATHER_FORECAST_CACH.containsKey(city)) {
            throw new IllegalArgumentException("There is no such city in the cache.");
        }
        WEATHER_FORECAST_CACH.put(city, weatherData);
    }

    public static void removeInfoWeatherByCity(String city) {
        if (!WEATHER_FORECAST_CACH.containsKey(city)) {
            throw new IllegalArgumentException("There is no such city in the cache.");
        }
        WEATHER_FORECAST_CACH.remove(city);
    }

    public static void printAllCity() {
        WEATHER_FORECAST_CACH.entrySet().forEach(System.out::println);
    }
}