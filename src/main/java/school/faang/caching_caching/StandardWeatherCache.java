package school.faang.caching_caching;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return data.getTimestamp() + maxCacheAgeMillis < System.currentTimeMillis();
    }
}
