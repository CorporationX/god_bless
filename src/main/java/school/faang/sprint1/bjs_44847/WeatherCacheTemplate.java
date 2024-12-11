package school.faang.sprint1.bjs_44847;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Logger logger = LoggerFactory.getLogger(WeatherCacheTemplate.class);
    private final Map<String, WeatherData> cacheData = new HashMap<>();

    protected abstract WeatherData fetchWeatherData(String string);

    protected abstract boolean isCacheValid(long cacheCreationTime, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (maxCacheAgeMillis <= 0) {
            logger.warn("Max cache age is not valid");
            return null;
        }
        WeatherData dataRecord = cacheData.get(city);
        if (dataRecord != null && isCacheValid(dataRecord.timestamp(), maxCacheAgeMillis)) {
            return dataRecord;
        }
        return forceUpdateWeatherData(city);
    }

    private WeatherData forceUpdateWeatherData(String city) {
        WeatherData updatedData = fetchWeatherData(city);
        cacheData.put(city, updatedData);
        return updatedData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cacheData.values().removeIf(record -> (System.currentTimeMillis() - record.timestamp()) >= maxCacheAgeMillis);
        logger.info("Cache cleared");
    }

    public void printAllCachedData() {
        if (cacheData.isEmpty()) {
            logger.warn("Empty cache");
        } else {
            System.out.println("Cache records:");
            cacheData.forEach( (city, data) -> System.out.printf("City: %s, data: %s%n", city, data));
        }
    }
}
