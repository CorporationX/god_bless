package school.faang;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> weatherCache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = weatherCache.get(city);

        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            updateWeatherData(city);
            data = updateWeatherData(city);
            weatherCache.put(city, data);
        }
        return data;
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) > maxCacheAgeMillis;
    }

    protected WeatherData updateWeatherData(String city) {
        WeatherProvider weatherProvider = new WeatherService();
        return weatherProvider.fetchWeatherData(city);
    }

    public abstract boolean isCacheValid(WeatherData data, long maxCacheAgeMillis);
}

