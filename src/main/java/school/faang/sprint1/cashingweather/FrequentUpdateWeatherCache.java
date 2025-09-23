package school.faang.sprint1.cashingweather;

/**
 * Frequent update mode: data is always considered stale,
 * meaning the provider is contacted for each request.
 */
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
