package school.faang.task_44843;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final long maxCacheAgeMillis;

    public FrequentUpdateWeatherCache(long maxCacheAgeMillis) {
        this.maxCacheAgeMillis = maxCacheAgeMillis;
    }

    @Override
    protected Boolean isExpired(WeatherData weatherData) {
        return checkTime(weatherData, maxCacheAgeMillis);
    }
}
