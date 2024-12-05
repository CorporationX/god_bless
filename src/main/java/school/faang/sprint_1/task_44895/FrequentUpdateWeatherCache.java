package school.faang.sprint_1.task_44895;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
