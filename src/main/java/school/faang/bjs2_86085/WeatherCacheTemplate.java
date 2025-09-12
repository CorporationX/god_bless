package school.faang.bjs2_86085;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherCache = new ConcurrentHashMap<>();
    private final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cachedData = weatherCache.get(city);

        if (cachedData == null || isCacheExpired(cachedData, maxCacheAgeMillis)) {
            WeatherData freshData = forceUpdateWeather(city);
            weatherCache.put(city, freshData);
            return freshData;
        }

        return cachedData;
    }

    public WeatherData forceUpdateWeather(String city) {
        return weatherProvider.fetchWeatherData(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        weatherCache.entrySet().removeIf(entry ->
                isCacheExpired(entry.getValue(), maxCacheAgeMillis)
        );
    }
}