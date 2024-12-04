package school.faang.task44828;

import java.util.Map;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(Map<String, WeatherData> cache) {
        super(cache);
    }

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        getWeatherData(city);
        return validityPeriod(city, maxCacheAgeMillis);
    }

    @Override
    public WeatherData getWeatherData(String city) {
        return cache.get(city);
    }

}
