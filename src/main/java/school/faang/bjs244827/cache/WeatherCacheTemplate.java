package school.faang.bjs244827.cache;

import lombok.Getter;
import school.faang.bjs244827.model.WeatherData;

import java.util.HashMap;

@Getter
public abstract class WeatherCacheTemplate {

    private final HashMap<String, WeatherData> cache = new HashMap<>();

    protected abstract boolean isCacheValid(WeatherData data, long maxCacheAgeMillis);

    protected abstract WeatherData refreshWeatherData(String city);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);

        if (data != null && isCacheValid(data, maxCacheAgeMillis)) {
            return data;
        }

        WeatherData refreshData = refreshWeatherData(city);
        cache.put(city, refreshData);
        return refreshData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> !isCacheValid(entry.getValue(), maxCacheAgeMillis));
    }
}

