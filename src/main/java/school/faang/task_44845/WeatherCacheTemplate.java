package school.faang.task_44845;

import school.faang.task_44845.entity.WeatherData;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cachedData = cache.get(city);
        if (cachedData != null && isCacheActual(cachedData, maxCacheAgeMillis)) {
            return cachedData;
        }
        WeatherData freshData = fetchNewData(city);
        cache.put(city, freshData);
        return freshData;
    }

    protected abstract boolean isCacheActual(WeatherData cachedData, long maxCacheAgeMillis);

    protected abstract WeatherData fetchNewData(String city);

}
