package school.faang.task_57024;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider weatherProvider;

    protected WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = updateWeatherData(city);
        }
        return data;
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    protected WeatherData updateWeatherData(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        cache.put(city, newData);
        return newData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        Iterator<Map.Entry<String, WeatherData>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WeatherData> entry = iterator.next();
            if (isCacheExpired(entry.getValue(), maxCacheAgeMillis)) {
                iterator.remove();
            }
        }
    }
}
