package faang.school.godbless.java_hashmap.BJS2_5634;

import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    private final Map<String, WeatherData> weatherCache;

    public WeatherService() {
        weatherCache = new HashMap<>();
    }

    private static WeatherData generateWeatherData(String city) {
        double temperature = Math.random() * 100;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }

    public WeatherData getWeatherByCity(String city) {
        if (weatherCache.containsKey(city)) {
            return weatherCache.get(city);
        }

        WeatherData weatherData = generateWeatherData(city);
        weatherCache.put(city, weatherData);

        return weatherData;
    }

    public void updateWeatherByCity(String city, WeatherData newWeatherData) {
        weatherCache.put(city, newWeatherData);
    }

    public void removeWeatherByCity(String city) {
        weatherCache.remove(city);
    }

    public void printCachedCities() {
        System.out.println("Список городов из кэша:");
        for (String city : weatherCache.keySet()) {
            System.out.println(city);
        }
    }
}
