package school.faang.caching_caching;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
