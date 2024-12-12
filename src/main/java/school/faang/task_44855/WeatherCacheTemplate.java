package school.faang.task_44855;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider provider;

    public WeatherCacheTemplate(WeatherProvider provider) {
        this.provider = provider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData newData = provider.fetchWeatherData(city);
        updateCache(city, newData);
        return newData;
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }

    protected void updateCache(String city, WeatherData data) {
        cache.put(city, data);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }

    public abstract long getMaxCacheAgeMillis();
}
