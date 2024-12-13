package school.faang.task_44866;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public final WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);

        if (data != null && !isCacheExpired(data, maxCacheAgeMillis)) {
            return data;
        }

        data = fetchAndCacheData(city);

        return data;
    }

    protected abstract boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis);

    protected WeatherData fetchAndCacheData(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        cache.put(city, newData);

        return newData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }
}
