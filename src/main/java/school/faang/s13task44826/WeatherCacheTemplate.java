package school.faang.s13task44826;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> weatherDataCache = new HashMap<>();

    public WeatherData getWeatherData(City city, long maxCacheAgeMillis) {
        WeatherData weatherData = weatherDataCache.get(city);
        if (weatherData != null && !isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return weatherData;
        } else {
            WeatherData updatedData = updateWeatherData(city);
            return updatedData;
        }
    }

    protected abstract boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis);

    protected abstract WeatherData updateWeatherData(City city);

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherDataCache.entrySet().removeIf(entry ->
                (System.currentTimeMillis() - entry.getValue().getTimestamp()) > maxCacheAgeMillis
        );
    }
}