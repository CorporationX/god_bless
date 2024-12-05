package school.faang.sprint_1.task_44895;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    public static Map<String, WeatherData> cache = new HashMap<>();
    private static final WeatherService weatherService = new WeatherService();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData currentData = cache.get(city);
        WeatherData updatedData = weatherService.fetchWeatherData(city);

        if (currentData == null || isCacheExpired(currentData, maxCacheAgeMillis)) {
            cache.put(city, updatedData);
        }
        return updatedData;
    }

    public void forceUpdateWeather(String city) {
        WeatherData data = weatherService.fetchWeatherData(city);
        cache.put(city, data);
        System.out.printf("Weather data to %s force updated\n", city);
    }

    public void clearExpiredCache (long maxCacheAgeMillis) {
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache();

        for (Map.Entry<String, WeatherData> entry : cache.entrySet()) {
            WeatherData data = entry.getValue();
            if (standardWeatherCache.isCacheExpired(data, maxCacheAgeMillis)) {
                cache.remove(data.getCity());
            }
        }
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

}

class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) >= maxCacheAgeMillis;
    }
}

class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
