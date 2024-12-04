package school.faang.task44828;

import java.time.Duration;
import java.util.Map;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private static final long MAX_CACHE_MILLIS = Duration.ofSeconds(10).toMillis();

    public StandardWeatherCache(Map<String, WeatherData> cache) {
        super(cache);
    }

    @Override
    protected WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        return cache.get(city);
    }

    @Override
    public WeatherData getWeatherData(String city) {
        return validityPeriod(city, MAX_CACHE_MILLIS);
    }
}
