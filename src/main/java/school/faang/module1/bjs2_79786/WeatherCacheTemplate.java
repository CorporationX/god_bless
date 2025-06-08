package school.faang.module1.bjs2_79786;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public abstract class WeatherCacheTemplate {

    private final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider provider;

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cachedData = cache.get(city);
        if (cachedData == null || isCacheExpired(cachedData, maxCacheAgeMillis)) {
            WeatherData freshData = provider.fetchWeatherData(city);
            cache.put(city, freshData);
            return freshData;
        }
        return cachedData;
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData freshWeatherData = provider.fetchWeatherData(city);
        if (freshWeatherData != null) {
            cache.put(city, freshWeatherData);
        }
        return freshWeatherData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }

    public String getCachedCities() {
        return "Кеш содержит города: " + cache.keySet();
    }
}