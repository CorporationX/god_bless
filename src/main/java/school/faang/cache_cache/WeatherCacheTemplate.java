package school.faang.cache_cache;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cityWeatherData = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cityWeatherData.get(city);
        if (weatherData != null && !isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return weatherData;
        }
        WeatherData newWeatherData = updateWeatherData(city);
        cityWeatherData.put(city, newWeatherData);
        return newWeatherData;
    }

    public abstract WeatherData updateWeatherData(String city);

    public abstract boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis);
}
