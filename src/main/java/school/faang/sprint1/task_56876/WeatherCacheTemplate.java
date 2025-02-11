package school.faang.sprint1.task_56876;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();

    protected WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (data != null && !isCacheExpired(data, maxCacheAgeMillis)) {
            return data;
        } else {
            return updateWeatherData(city);
        }
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) > maxCacheAgeMillis;
    }

    protected WeatherData updateWeatherData(String city) {
        WeatherService weatherService = new WeatherService();
        WeatherData newData = weatherService.fetchWeatherData(city);
        cache.put(city, newData);
        return newData;
    }
}
