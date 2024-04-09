package faang.school.godbless.module.hashmap.keshiruem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Map<String, WeatherData> CITY_TO_WEATHER_CACHE = new HashMap<>();
    
    public static void main(String[] args) {
        updateWeatherInfo("Moscow");
        updateWeatherInfo("Kaliningrad");
        updateWeatherInfo("Piter");
        printWeatherInfo(CITY_TO_WEATHER_CACHE);
        deleteCacheByCity("Piter");
        printWeatherInfo(CITY_TO_WEATHER_CACHE);
        getWeatherByCity("Ufa");
        printWeatherInfo(CITY_TO_WEATHER_CACHE);
    }
    
    public static WeatherData getWeatherByCity(String city) {
        WeatherData weatherData = CITY_TO_WEATHER_CACHE.get(city);
        if (weatherData != null) {
            return weatherData;
        }
        return updateWeatherInfo(city);
    }
    
    private static WeatherData updateWeatherInfo(String city) {
        WeatherDataService.update(city);
        Random random = new Random();
        return CITY_TO_WEATHER_CACHE.put(city, new WeatherData(city, random.nextInt(60), random.nextInt(100)));
    }
    
    public static void deleteCacheByCity(String city) {
        CITY_TO_WEATHER_CACHE.remove(city);
    }
    
    public static void printWeatherInfo(Map<String, WeatherData> weatherInfoCache) {
        System.out.println("All cities");
        weatherInfoCache.values().forEach(weatherData -> {
            if (weatherData == null) {
                return;
            }
            System.out.printf(
                "City: %s. Temperature: %d. Humidity: %d \n",
                weatherData.getCity(),
                weatherData.getTemperature(),
                weatherData.getHumidity()
            );
        });
    }
}
