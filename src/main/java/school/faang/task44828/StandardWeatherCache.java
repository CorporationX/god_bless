package school.faang.task44828;

import java.time.Duration;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private static final long MAX_CACHE_MILLIS = Duration.ofSeconds(10).toMillis();

    @Override
    public WeatherData getWeatherData(String city) {
        return validityPeriod(city, MAX_CACHE_MILLIS);
    }

    @Override
    protected void isExpired(String city) {
        validityPeriod(city, MAX_CACHE_MILLIS);
    }
}
