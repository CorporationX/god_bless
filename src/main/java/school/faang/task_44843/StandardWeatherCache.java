package school.faang.task_44843;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private static final long MAX_CACHE_MILLS = 1000;

    @Override
    protected Boolean isExpired(WeatherData weatherData) {
        return checkTime(weatherData, MAX_CACHE_MILLS);
    }
}
