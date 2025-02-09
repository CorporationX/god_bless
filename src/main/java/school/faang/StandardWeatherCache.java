package school.faang;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheValid(WeatherData data, long maxCacheAgeMillis) {
        return !isCacheExpired(data, maxCacheAgeMillis);
    }
}
