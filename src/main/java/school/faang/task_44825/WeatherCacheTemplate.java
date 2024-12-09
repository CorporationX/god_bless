package school.faang.task_44825;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> data;
    private final WeatherService weatherService;

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City field is required");
        }
        if (isCacheExpired(data.get(city), maxCacheAgeMillis)) {
            updateCache(city);
        }
        return data.get(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        data.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }

    private void updateCache(String city) {
        WeatherData actualWeatherData = weatherService.fetchWeatherData(city);
        if (actualWeatherData == null) {
            throw new NoSuchElementException("Weather data for current city is absent");
        }
        data.put(city, actualWeatherData);
    }
}