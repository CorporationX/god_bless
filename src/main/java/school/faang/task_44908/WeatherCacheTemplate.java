package school.faang.task_44908;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherCache = new HashMap<>();

    protected abstract WeatherData fetchWeatherDataFromProvider(String city);

    protected abstract boolean isDataFresh(WeatherData weatherData);

    protected WeatherData getWeatherData(String city) {

        final WeatherData weatherData = weatherCache.get(city);

        if (weatherData != null && isDataFresh(weatherData)) {
            log.info("\nReturning cached weather data for city:\n{}", city);
            return weatherData;
        }

        final WeatherData freshData = fetchWeatherDataFromProvider(city);

        weatherCache.put(city, freshData);

        log.info("\nFetched and cached fresh weather data for city:\n{}\n{}", city, freshData);
        return freshData;
    }

    protected void clearExpiredCache(long maxCacheAgeMillis) {
        if (weatherCache.isEmpty()) {
            log.info("\nCache is empty!");
            return;
        }

        final long currentTimestamp = System.currentTimeMillis();

        boolean isCacheCleared = weatherCache.entrySet().removeIf(entry -> {
            WeatherData weatherData = entry.getValue();
            long cachedTimestamp = weatherData.getTimestamp();
            boolean isExpired = currentTimestamp - cachedTimestamp > maxCacheAgeMillis;

            log.info("\n{}", entry.getKey());

            if (isExpired) {
                log.info("Removing expired cache");
            }

            return isExpired;
        });

        if (isCacheCleared) {
            log.info("Cache cleanup completed -> Expired entries were removed");
        } else {
            log.info("No expired cache entries to remove");
        }
    }

    public boolean isEmpty() {
        return weatherCache.isEmpty();
    }
}
