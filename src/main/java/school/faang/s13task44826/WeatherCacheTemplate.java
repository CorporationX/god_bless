package school.faang.s13task44826;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> weatherDataCache = new HashMap<>();

    public WeatherData getWeatherData(City city, long maxCacheAgeMillis) {
        if (!weatherDataCache.isEmpty() && isCacheExpired(weatherDataCache.get(city), maxCacheAgeMillis)) {
            log.info("weather data are actual");
        } else {
            updateWeatherData(city);
            log.info("weather data have updated");
        }
        return weatherDataCache.get(city);
    }

    protected abstract boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis);

    protected abstract void updateWeatherData(City city);

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherDataCache.entrySet().removeIf(entry ->
                (System.currentTimeMillis() - entry.getValue().getTimestamp()) > maxCacheAgeMillis
        );
    }
}