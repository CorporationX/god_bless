package school.faang.task_44839;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData result;

        WeatherData weatherData = cache.get(city);
        if (weatherData != null && !isCacheExpired(weatherData, maxCacheAgeMillis)) {
            result = weatherData;
        } else {
            result = forceUpdateWeather(city);
        }

        return result;
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData forceUpdateWeather(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        cache.put(city, newData);
        System.out.printf("Weather data for %s updated manually.%n", city);
        return newData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
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
