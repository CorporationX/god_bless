package school.faang.cache_cache;

import school.faang.util.DatesUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> cache;
    private WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.cache = new HashMap<>();
        this.weatherProvider = weatherProvider;
    }

    public abstract boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cache.get(city);
        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            cache.put(city, weatherProvider.fetchWeatherData(city));
            return cache.get(city);
        }

        return weatherData;
    }

    public WeatherData forceUpdateWeather(String city) {
        cache.put(city, weatherProvider.fetchWeatherData(city));
        return cache.get(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        Iterator<Map.Entry<String, WeatherData>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WeatherData> entry = iterator.next();
            if (isCacheExpired(entry.getValue(), maxCacheAgeMillis)) {
                iterator.remove();
            }
        }
    }
}
