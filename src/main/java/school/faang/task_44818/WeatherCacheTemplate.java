package school.faang.task_44818;

import lombok.Getter;

import java.util.HashMap;

@Getter
public abstract class WeatherCacheTemplate {
    private final HashMap<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (isCacheValid(data, maxCacheAgeMillis)) {
            return data;
        }

        WeatherData freshData = fetchWeatherData(city);
        cache.put(city, freshData);
        return freshData;
    }


    protected abstract boolean isCacheValid(WeatherData cachedData, long maxCacheAgeMillis);

    protected abstract WeatherData fetchWeatherData(String city);

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> !isCacheValid(entry.getValue(), maxCacheAgeMillis));
    }
}
