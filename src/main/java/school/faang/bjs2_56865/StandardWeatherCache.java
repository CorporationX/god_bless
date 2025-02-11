package school.faang.bjs2_56865;

public class StandardWeatherCache extends WeatherCacheTemplate {
    StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long differenceMillis = System.currentTimeMillis() - data.getTimestamp();
        return differenceMillis > maxCacheAgeMillis;
    }
}
