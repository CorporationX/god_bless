package school.faang.cacheCache;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTimestamp = System.currentTimeMillis();
        return currentTimestamp - data.timestamp() > maxCacheAgeMillis;
    }
}