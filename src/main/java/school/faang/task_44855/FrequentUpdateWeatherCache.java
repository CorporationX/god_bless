package school.faang.task_44855;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    public long getMaxCacheAgeMillis() {
        return 0;
    }
}
