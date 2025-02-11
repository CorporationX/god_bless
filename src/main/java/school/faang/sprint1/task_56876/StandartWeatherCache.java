package school.faang.sprint1.task_56876;

public class StandartWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return (System.currentTimeMillis() - data.getTimestamp()) > maxCacheAgeMillis;
    }
}
