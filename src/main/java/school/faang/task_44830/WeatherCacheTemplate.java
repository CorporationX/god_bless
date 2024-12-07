package school.faang.task_44830;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAge) {
        WeatherData cacheRequest = cache.get(city);

        if (isCacheValid(cacheRequest, maxCacheAge) && cacheRequest != null) {
            return cacheRequest;
        }

        WeatherData noCacheRequest = fetchFreshData(city);
        updateCache(city, noCacheRequest);
        return noCacheRequest;
    }

    protected abstract WeatherData fetchFreshData(String city);

    protected abstract boolean isCacheValid(WeatherData data, long maxCacheAge);

    protected void updateCache(String city, WeatherData data) {
        cache.put(city, data);
    }

    public void clearCache(long maxCacheAge) {
        cache.entrySet()
                .removeIf(s -> !isCacheValid(s.getValue(), maxCacheAge));
    }
}