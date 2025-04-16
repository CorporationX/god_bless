package school.faang.caching_caching;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class WeatherCacheTemplate {

    private final WeatherProvider weatherProvider;
    @Getter
    private Map<String, WeatherData> weatherDataCache = new HashMap<>();

    protected WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public abstract boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis);

    public WeatherData getWeatherData(@NonNull String city, long maxCacheAgeMillis) {
        weatherDataCache.computeIfAbsent(city, weatherProvider::fetchWeatherData);

        if (isCacheExpired(weatherDataCache.get(city), maxCacheAgeMillis)) {
            forceUpdateWeather(city);
        }
        return weatherDataCache.get(city);
    }

    public void forceUpdateWeather(String city) {
        weatherDataCache.put(city, weatherProvider.fetchWeatherData(city));
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherDataCache = weatherDataCache
                .entrySet()
                .stream()
                .filter(entry -> !isCacheExpired(entry.getValue(), maxCacheAgeMillis))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}