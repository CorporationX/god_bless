package school.faang.cache.cachetemplate;

import school.faang.cache.WeatherData;
import school.faang.cache.WeatherProvider;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}