package school.faang.cash.cash;

import java.util.HashMap;
import java.util.Map;


public abstract class WeatherCacheTemplate {
    Map<String, WeatherData> weatherCache = new HashMap<>();
    WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    protected WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cachedData = weatherCache.get(city);
        if (cachedData != null && !isCacheExpired(cachedData, maxCacheAgeMillis)) {
            return cachedData;
        }
        WeatherData freshData = forceUpdateWeather(city);
        weatherCache.put(city, freshData);
        return freshData;
    }

    WeatherData forceUpdateWeather(String city) {
        WeatherData freshData = weatherProvider.fetchWeatherData(city);
        weatherCache.put(city, freshData);
        return freshData;
    }

    void clearExpiredCache(long maxCacheAgeMillis) {
        weatherCache.entrySet().removeIf(entry ->
                isCacheExpired(entry.getValue(), maxCacheAgeMillis)
        );
    }
}
