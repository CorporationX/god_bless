package school.faang.bjs244832;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private static final Logger logger = LoggerFactory.getLogger(WeatherCacheTemplate.class);
    protected WeatherProvider weatherProvider;
    protected Map<String, WeatherData> cache = new HashMap<>();

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        if (weatherProvider == null) {
            logger.error("WeatherProvider cannot be null");
            throw new IllegalArgumentException("WeatherProvider cannot be null");
        }
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (city == null || city.trim().isEmpty()) {
            logger.error("City cannot be null or empty");
            throw new IllegalArgumentException("City cannot be null or empty");
        }

        if (maxCacheAgeMillis < 0) {
            logger.error("maxCacheAgeMillis cannot be negative");
            throw new IllegalArgumentException("maxCacheAgeMillis cannot be negative");
        }

        WeatherData data = cache.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = weatherProvider.fetchWeatherData(city);
            cache.put(city, data);
            logger.info("Updated weather data for city: {}", city);
        } else {
            logger.info("Using cached weather data for city: {}", city);
        }
        return data;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        if (maxCacheAgeMillis < 0) {
            logger.error("maxCacheAgeMillis cannot be negative");
            throw new IllegalArgumentException("maxCacheAgeMillis cannot be negative");
        }
        long currentTime = System.currentTimeMillis();
        cache.entrySet().removeIf(entry -> (currentTime - entry.getValue().getTimestamp()) > maxCacheAgeMillis);
        logger.info("Cleared expired cache entries");
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);
}