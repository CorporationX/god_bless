package school.faang.task_44825;

import java.util.Map;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(Map<String, WeatherData> data, WeatherService weatherService) {
        super(data, weatherService);
    }

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}