package school.faang.task_56876;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
