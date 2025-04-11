package school.faang.cachecache;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return false;
    }
}
