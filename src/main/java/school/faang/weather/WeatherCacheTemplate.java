package school.faang.weather;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new ConcurrentHashMap<>();
    private final WeatherProvider weatherProvider = new WeatherService();

    protected WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData;

        if (isCacheExpired(cache.get(city), maxCacheAgeMillis)) {
            weatherData = weatherProvider.fetchWeatherData(city);
            cache.put(city, weatherData);
        } else {
            weatherData = cache.get(city);
        }

        return weatherData;
    }

    protected WeatherData forceUpdateWeather(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        cache.put(city, weatherData);
        return weatherData;
    }

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);
}
