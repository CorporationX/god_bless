package school.faang.cachingweather;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
