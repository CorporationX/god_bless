package school.faang.bjs2_79802;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherService provider) {
        super(provider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return currentTime - data.getTimestamp() > maxCacheAgeMillis;
    }
}
