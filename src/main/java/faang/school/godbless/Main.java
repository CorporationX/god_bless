package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    private static final Map<String, WeatherData> WEATHER_DATA_CACHE = new HashMap<>();

    public static WeatherData getWeatherData(String city) {
        Objects.requireNonNull(city);
        WeatherData weatherData = WEATHER_DATA_CACHE.get(city);

        if (weatherData == null) {
            weatherData = new MockWeatherService().getWeather(city);
            WEATHER_DATA_CACHE.put(city, weatherData);
            return weatherData;
        }

        return weatherData;
    }

    public static void updateWeatherData(String city, WeatherData weatherData) {
        Objects.requireNonNull(city);
        Objects.requireNonNull(weatherData);

        if (WEATHER_DATA_CACHE.containsKey(city)) {
            WEATHER_DATA_CACHE.put(city, weatherData);
        } else {
            throw new RuntimeException("WeatherData not found");
        }
    }

    public static void deleteWeatherData(String city) {
        Objects.requireNonNull(city);

        if (WEATHER_DATA_CACHE.containsKey(city)) {
            WEATHER_DATA_CACHE.remove(city);
        } else {
            throw new RuntimeException("WeatherData not found");
        }
    }

    public static void printWeatherData() {
        WEATHER_DATA_CACHE.values().stream().forEach(System.out::println);
    }
}
