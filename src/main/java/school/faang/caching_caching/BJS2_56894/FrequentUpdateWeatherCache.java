package school.faang.caching_caching.BJS2_56894;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache() {
        super(new WeatherService());
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
