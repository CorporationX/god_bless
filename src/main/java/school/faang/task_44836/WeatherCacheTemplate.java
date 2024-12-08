package school.faang.task_44836;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {
    private final HashMap<String, WeatherData> cache = new HashMap<>();
    protected WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }

        WeatherData cachedData = cache.get(city);
        if (cachedData != null && !isCacheExpired(cachedData, maxCacheAgeMillis)) {
            System.out.println("Returning data from cache for city: " + city);
            return cachedData;
        }

        System.out.println("Data is outdated or missing. We are updating for the city: " + city);
        return forceUpdateWeather(city);
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return (System.currentTimeMillis() - data.timestamp()) > maxCacheAgeMillis;
    }

    protected WeatherData forceUpdateWeather(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        cache.put(city, newData);
        System.out.println("Weather data for " + city + " updated.");
        return newData;
    }
}