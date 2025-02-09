package school.faang;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> weatherCache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = weatherCache.get(city);

        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            updateWeatherData(city);
            data = weatherCache.get(city);
        }
        return data;
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) > maxCacheAgeMillis;
    }

    protected void updateWeatherData(String city) {
        WeatherProvider weatherProvider = new WeatherService();
        WeatherData newData = weatherProvider.feachWeatherData(city);
        weatherCache.put(city, newData);
    }

    public abstract boolean isCacheValid(WeatherData data, long maxCacheAgeMillis);
}

