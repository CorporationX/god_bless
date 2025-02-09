package school.faang;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheValid(WeatherData data, long maxCacheAgeMillis) {
        return false;
    }
}
