package faang.school.godbless.cache_cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final MockWeatherService MOCK_WEATHER_SERVICE = new MockWeatherService();

    private static final Map<String, WeatherData> WEATHER_DATA_CACHE = new HashMap<>();

    public static WeatherData getWeatherData(String city) {
        Objects.requireNonNull(city);
        WeatherData weatherData = WEATHER_DATA_CACHE.get(city);

        if (weatherData == null) {
            weatherData = MOCK_WEATHER_SERVICE.getWeather(city);
            WEATHER_DATA_CACHE.put(city, weatherData);
        }

        return weatherData;
    }

    public static void updateWeatherData(WeatherData weatherData) {
        Objects.requireNonNull(weatherData);

        if (WEATHER_DATA_CACHE.containsKey(weatherData.getCity())) {
            WEATHER_DATA_CACHE.put(weatherData.getCity(), weatherData);
        }
    }

    public static void deleteWeatherData(String city) {
        Objects.requireNonNull(city);
        WEATHER_DATA_CACHE.remove(city);
    }

    public static void printWeatherData() {
        WEATHER_DATA_CACHE.values().stream().forEach(System.out::println);
    }
}
