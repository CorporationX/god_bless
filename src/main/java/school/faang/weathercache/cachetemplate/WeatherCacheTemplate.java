package school.faang.weathercache.cachetemplate;

import lombok.Getter;
import school.faang.weathercache.WeatherData;
import school.faang.weathercache.WeatherProvider;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;
    private final Map<String, WeatherData> weatherCache;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
        this.weatherCache = new HashMap<>();
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cachedData = weatherCache.get(city);

        if (cachedData == null || isCacheExpired(cachedData, maxCacheAgeMillis)) {
            WeatherData freshData = weatherProvider.fetchWeatherData(city);
            weatherCache.put(city, freshData);
            return freshData;
        }

        return cachedData;
    }

    public final WeatherData forceUpdateWeather(String city) {
        WeatherData data = weatherProvider.fetchWeatherData(city);
        weatherCache.put(city, data);
        return data;
    }

    public final boolean clearExpiredCache(long maxCacheAgeMillis) {
        return weatherCache.entrySet().removeIf(entry ->
                isCacheExpired(entry.getValue(), maxCacheAgeMillis)
        );
    }
}
