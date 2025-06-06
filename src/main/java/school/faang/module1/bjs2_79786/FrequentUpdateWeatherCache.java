package school.faang.module1.bjs2_79786;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}