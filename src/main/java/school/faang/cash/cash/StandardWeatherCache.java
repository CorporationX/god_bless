package school.faang.cash.cash;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return (System.currentTimeMillis() - data.getTimestamp()) > maxCacheAgeMillis;
    }

}
