package school.faang.cashecashe.maincode;

import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    public static WeatherData getWeather(String city, Map<String, WeatherData> weatherCache,
                                         WeatherMockService weatherService) {
        if (weatherCache.containsKey(city)) {
            return weatherCache.get(city);
        }
        WeatherData weatherData = weatherService.getWeatherData(city);
        weatherCache.put(city, weatherData);
        return weatherData;
    }

    public static void updateWeather(String city, Map<String, WeatherData> weatherCache,
                                     WeatherMockService weatherService) {
        WeatherData updateWeatherData = weatherService.getWeatherData(city);
        weatherCache.put(city, updateWeatherData);
    }

    public static void removeWeather(String city, Map<String, WeatherData> weatherCache) {
        weatherCache.remove(city);
    }

    public static String getAllCity(Map<String, WeatherData> weatherCache) {
        return weatherCache.keySet().toString();
    }
}
