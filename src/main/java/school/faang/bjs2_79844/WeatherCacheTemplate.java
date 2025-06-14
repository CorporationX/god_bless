package school.faang.bjs2_79844;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@AllArgsConstructor
public abstract class WeatherCacheTemplate {
    protected WeatherProvider provider;
    protected Map<String, WeatherData> cache = new HashMap<>();

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = provider.fetchWeatherData(city);
            cache.put(city, data);
        }
        return data;
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData data = provider.fetchWeatherData(city);
        cache.put(city, data);
        return data;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        Iterator<Map.Entry<String, WeatherData>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            WeatherData data = entry.getValue();

            if (isCacheExpired(data, maxCacheAgeMillis)) {
                iterator.remove();
            }
        }
    }
}
