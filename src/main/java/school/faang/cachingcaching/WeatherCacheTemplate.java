package school.faang.cachingcaching;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected Map<String, WeatherData> cache = new HashMap<>();
    protected WeatherProvider provider;

    public WeatherCacheTemplate(WeatherProvider provider) {
        this.provider = provider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (cache.containsKey(city)) {
            WeatherData data = cache.get(city);
            if (!isCacheExpired(data, maxCacheAgeMillis)) {
                return data;
            }
        }
        WeatherData newData = provider.fetchWeatherData(city);
        cache.put(city, newData);
        return newData;
    }

    public void forceUpdateWeather(String city) {
        WeatherData newData = provider.fetchWeatherData(city);
        cache.put(city, newData);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);
}
