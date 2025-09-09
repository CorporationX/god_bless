package school.faang.BJS2_86058;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
