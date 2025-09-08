package school.faang.module1.weather;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new ConcurrentHashMap<>();
    private final WeatherProvider weatherProvider = new WeatherService();

    protected WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (isCacheExpired(cache.get(city), maxCacheAgeMillis)) {
            WeatherData weatherData = weatherProvider.fetchWeatherData(city);
            cache.put(city, weatherData);
            return weatherData;
        }

        return cache.get(city);
    }

    protected WeatherData forceUpdateWeather(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        cache.put(city, weatherData);
        return weatherData;
    }

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);
}
