package school.faang.sprintone.cachingcaching;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return currentTime - data.getTimestamp() > maxCacheAgeMillis;
    }
}
