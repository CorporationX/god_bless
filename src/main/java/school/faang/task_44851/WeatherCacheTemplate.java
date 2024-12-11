package school.faang.task_44851;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cachedData = cache.get(city);
        if (cachedData != null && !isCacheExpired(cachedData, maxCacheAgeMillis)) {
            return cachedData;
        }

        return fetchAndUpdateCache(city);
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return currentTime - data.getTimestamp() > maxCacheAgeMillis;
    }

    protected WeatherData fetchAndUpdateCache(String city) {
        WeatherData freshData = fetchFreshData(city);
        cache.put(city, freshData);
        return freshData;
    }

    protected abstract WeatherData fetchFreshData(String city);

    public void clearExpiredCache(long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        cache.entrySet().removeIf(entry ->
                currentTime - entry.getValue().getTimestamp() > maxCacheAgeMillis);
    }
}