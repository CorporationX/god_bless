package school.faang.sprint1.cashingweather;

/**
 * Regular cache mode: data is considered stale
 * if more than  {@code maxCacheAgeMillis} milliseconds have passed since it was recorded.
 */
public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long now = System.currentTimeMillis();
        return (now - data.timestamp()) > maxCacheAgeMillis;
    }
}
