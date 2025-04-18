package school.faang.bjs2_69948;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> weatherCache = new HashMap<>();
    protected final WeatherProvider cacheProvider;

    public WeatherCacheTemplate(WeatherProvider provider) {
        this.cacheProvider = provider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        var weatherData = weatherCache.get(city);
        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            weatherData = cacheProvider.fetchWeatherData(city);
            weatherCache.put(city, weatherData);
        }

        return weatherData;
    }

    public void forceUpdateWeather(String city) {
        var weatherData = cacheProvider.fetchWeatherData(city);
        weatherCache.put(city, weatherData);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherCache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);
}