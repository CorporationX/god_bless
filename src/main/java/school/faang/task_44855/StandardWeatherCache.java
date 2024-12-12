package school.faang.task_44855;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private final long maxCacheAgeMillis;

    public StandardWeatherCache(WeatherProvider provider, long maxCacheAgeMillis) {
        super(provider);
        this.maxCacheAgeMillis = maxCacheAgeMillis;
    }

    @Override
    public long getMaxCacheAgeMillis() {
        return maxCacheAgeMillis;
    }
}
