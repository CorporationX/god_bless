package school.faang.bjs2_86050;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }
}
