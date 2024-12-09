package school.faang.task_44843;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private static final long SECONDS_TO_MILLIS = 1000;
    private static final long MAX_CACHE_MILLIS = SECONDS_TO_MILLIS;

    @Override
    protected Boolean isExpired(WeatherData weatherData) {
        return checkTime(weatherData, MAX_CACHE_MILLIS);
    }
}
