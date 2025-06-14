package school.faang.bjs2_79844;

import java.util.HashMap;

public class StandartWeatherCache extends WeatherCacheTemplate {
    public StandartWeatherCache(WeatherService weatherService) {
        super(weatherService, new HashMap<>());
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) > maxCacheAgeMillis;
    }
}
