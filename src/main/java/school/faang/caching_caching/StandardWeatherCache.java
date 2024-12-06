package school.faang.caching_caching;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        if (data.getTimestamp() + maxCacheAgeMillis < System.currentTimeMillis()) {
            return true;
        } else
            return false;
    }
}
