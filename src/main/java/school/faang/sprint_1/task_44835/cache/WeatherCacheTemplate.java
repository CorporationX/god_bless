package school.faang.sprint_1.task_44835.cache;

import lombok.NonNull;
import school.faang.sprint_1.task_44835.dto.WeatherData;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherDataCache = new HashMap<>();

    public final WeatherData getWeatherData(@NonNull String city, long maxCacheAgeMillis) {
        if (maxCacheAgeMillis <= 0) {
            throw new IllegalArgumentException("Max cache age must be greater then 0");
        }
        var weatherData = weatherDataCache.get(city);
        if (weatherData != null && checkRelevanceCache(weatherData.getTimestamp(), maxCacheAgeMillis)) {
            return weatherData;
        }
        return forceUpdateWeatherData(city);
    }

    private WeatherData forceUpdateWeatherData(String city) {
        var recentWeatherData = fetchWeatherData(city);
        weatherDataCache.put(city, recentWeatherData);
        return recentWeatherData;
    }

    protected abstract WeatherData fetchWeatherData(String city);

    protected abstract boolean checkRelevanceCache(long cacheCreationTime, long maxCacheAgeMillis);

    protected long getCurrentTime() {
        return Instant.now().toEpochMilli();
    }

    private void clearExpiredCache(long maxCacheAgeMillis) {
        weatherDataCache.values().removeIf(weatherData ->
                (getCurrentTime() - weatherData.getTimestamp()) >= maxCacheAgeMillis
        );
    }
}
