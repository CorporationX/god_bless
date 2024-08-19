package faang.school.godbless.dolbahlop;

import java.util.HashMap;
import java.util.Map;

public class WeatherCache {
    private final Map<String, WeatherData> weatherCache = new HashMap<>();
    private final WeatherService weatherService;

    public WeatherCache(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public WeatherData getWeather(String city) {
        if (weatherCache.containsKey(city)) {
            return weatherCache.get(city);
        } else {
            WeatherData data = weatherService.getWeatherData(city);
            weatherCache.put(city, data);
            return data;
        }
    }

    public void updateWeather(String city) {
        WeatherData data = weatherService.getWeatherData(city);
        weatherCache.put(city, data);
    }

    public void removeWeather(String city) {
        weatherCache.remove(city);
    }

    public Map<String, WeatherData> getAllCities() {
        return new HashMap<>(weatherCache);
    }
}
