package school.faang.task_44839;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cache.get(city);
        if (weatherData != null && !isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return weatherData;
        }

        forceUpdateWeather(city);
        return cache.get(city);
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public void forceUpdateWeather(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        cache.put(city, newData);
        System.out.printf("Weather data for %s updated manually.%n", city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        List<String> keysToRemove = new ArrayList<>();
        cache.forEach((city, weatherData) -> {
            if (isCacheExpired(weatherData, maxCacheAgeMillis)) {
                keysToRemove.add(city);
            }
        });

        keysToRemove.forEach(cache::remove);
    }

    public void printAllCacheData() {
        if (cache.isEmpty()) {
            System.out.println("Cache is empty.");
        } else {
            cache.forEach((city, weatherData) ->
                    System.out.printf("%s - %s%n", city, weatherData));
        }
    }

}
