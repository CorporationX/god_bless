package school.faang.caching_caching.BJS2_56894;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherCacheTemplate.class);

    private final Map<String, WeatherData> cache = new HashMap<>();

    private final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public final WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (city == null || city.isBlank()) {
            LOGGER.warn("City is null or empty");
            throw new IllegalArgumentException("City is null or empty");
        }

        if (maxCacheAgeMillis < 0) {
            LOGGER.warn("maxCacheAgeMillis is negative");
            throw new IllegalArgumentException("maxCacheAgeMillis is negative");
        }

        if (cache.containsKey(city) && !isCacheExpired(cache.get(city), maxCacheAgeMillis)) {
            return cache.get(city);
        }
        return updateWeatherData(city);
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    protected WeatherData updateWeatherData(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        if (weatherData == null) {
            LOGGER.warn("WeatherData is null");
            throw new IllegalArgumentException("WeatherData is null");
        }
        cache.put(city, weatherData);
        return weatherData;
    }

    protected void clearExpiredCache(long maxCacheAgeMillis) {
        cache.forEach((city, data) -> {
            if ((System.currentTimeMillis() - data.timestamp()) > maxCacheAgeMillis) {
                WeatherData updatedData = weatherProvider.fetchWeatherData(city);
                cache.put(city, updatedData);
            }
        });
    }
}
