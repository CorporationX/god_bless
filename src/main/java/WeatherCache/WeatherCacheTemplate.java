package WeatherCache;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class WeatherCacheTemplate {
    private static final Logger logger = Logger.getLogger(WeatherCacheTemplate.class.getName());
    private final Map<String, WeatherData> weatherDataCache = new HashMap<>();
    private final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cachedData = weatherDataCache.get(city);
        if (cachedData != null && !isCacheExpired(cachedData, maxCacheAgeMillis)) {
            logger.info("Returning data from cache for city: " + city);
            return cachedData;
        }
        logger.info("Data for the city of " + city + " are outdated or missing. Updating data...");
        return updateWeatherData(city);
    }

    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }

    public WeatherData updateWeatherData(String city) {
        try {
            WeatherData freshData = weatherProvider.fetchWeatherData(city);
            weatherDataCache.put(city, freshData);
            logger.info("Data for the city of " + city + " has been updated!");
            return freshData;
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, "Failed to update data for city: " + city, e);
            return null;
        }
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherDataCache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
        logger.info("Outdated data has been removed from the cache!");
    }
}