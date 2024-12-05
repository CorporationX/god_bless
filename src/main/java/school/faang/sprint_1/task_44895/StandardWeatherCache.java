package school.faang.sprint_1.task_44895;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) >= maxCacheAgeMillis;
    }
}
