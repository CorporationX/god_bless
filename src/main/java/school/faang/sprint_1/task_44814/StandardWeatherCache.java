package school.faang.sprint_1.task_44814;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) > maxCacheAgeMillis;
    }
}
