package school.faang.сatchingCatching;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheValid(WeatherData data, long maxCacheAgeMillis) {
        return false;
    }
}
