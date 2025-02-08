package school.faang.bjs2_56865;

import java.util.HashMap;
import java.util.Map;

abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> weatherCache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (!weatherCache.containsKey(city) || isCacheExpired(weatherCache.get(city), maxCacheAgeMillis)) {
            updateWeatherData(city);
        }
        return weatherCache.get(city);
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    protected abstract void updateWeatherData(String city);

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherCache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }
}
