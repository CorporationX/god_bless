package school.faang.bjs2_68918;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
