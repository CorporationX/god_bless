package school.faang.bjs2_79765;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherService weatherService) {
        super(weatherService);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }
}
