package school.faang.weathercache;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
