package school.faang.task44870.controller;

import school.faang.task44870.model.WeatherData;
import school.faang.task44870.service.WeatherProvider;
import school.faang.task44870.service.WeatherService;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    private final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider weatherProvider = new WeatherService();

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (data != null) {
            if (isCacheExpired(data, maxCacheAgeMillis)) {
                forceUpdateWeather(city);
            }
        } else {
            forceUpdateWeather(city);
        }

        return cache.get(city);
    }

    private void forceUpdateWeather(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        cache.put(city, weatherData);
        System.out.println("Weather data was refreshed!");
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        cache.entrySet().removeIf(entry -> (currentTime - entry.getValue().getTimestamp() > maxCacheAgeMillis));
    }


}
