package school.faang.cache;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider provider;

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);

        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = forceUpdateWeather(city);
        }

        return data;
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData data = provider.fetchWeatherData(city);
        cache.put(city, data);
        return data;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }
}
