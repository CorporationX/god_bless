package school.faang.bjs2_79802;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
