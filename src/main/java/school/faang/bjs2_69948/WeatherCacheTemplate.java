package school.faang.bjs2_69948;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherCache = new HashMap<>();
    private final WeatherProvider cacheProvider;

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = weatherCache.get(city);
        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            forceUpdateWeather(city);
        }

        return weatherData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherCache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    private void forceUpdateWeather(String city) {
        var weatherData = cacheProvider.fetchWeatherData(city);
        weatherCache.put(city, weatherData);
    }
}