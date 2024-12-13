package school.faang.sprint_1.task_44855;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    public long getMaxCacheAgeMillis() {
        return 0;
    }
}
