package school.faang.task_44825;

import java.util.Map;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(Map<String, WeatherData> data, WeatherService weatherService) {
        super(data, weatherService);
    }

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) > maxCacheAgeMillis;
    }
}