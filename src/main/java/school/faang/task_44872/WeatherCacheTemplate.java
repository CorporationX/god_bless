package school.faang.task_44872;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate implements WeatherProvider {
    protected Map<String, WeatherData> cache = new HashMap<>();

    @Override
    public WeatherData fetchWeatherData(String city) {
        long maxCacheAgeMillis = 5000;
        if (isDataInCacheAndValid(city, maxCacheAgeMillis)) {
            return cache.get(city);
        } else {
            WeatherData newData = getWeatherDataFromProvider(city);
            updateCache(city, newData);
            return newData;
        }
    }

    private boolean isDataInCacheAndValid(String city, long maxCacheAgeMillis) {
        if (cache.containsKey(city)) {
            WeatherData cachedData = cache.get(city);
            long currentTime = System.currentTimeMillis();
            return (currentTime - cachedData.getTimestamp()) <= maxCacheAgeMillis;
        }
        return false;
    }

    private void updateCache(String city, WeatherData data) {
        cache.put(city, data);
    }

    protected abstract WeatherData getWeatherDataFromProvider(String city);

    protected abstract long getMaxCacheAgeMillis();
}
