package school.faang.bjs2_56915;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        long dataAge = currentTime - data.getTimestamp();
        return dataAge > maxCacheAgeMillis;
    }
}
