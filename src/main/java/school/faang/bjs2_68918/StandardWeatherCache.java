package school.faang.bjs2_68918;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.timestamp() >= maxCacheAgeMillis;
    }
}
