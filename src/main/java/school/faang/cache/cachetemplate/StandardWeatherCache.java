package school.faang.cache.cachetemplate;

import school.faang.cache.WeatherData;
import school.faang.cache.WeatherProvider;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() > data.getTimestamp() + maxCacheAgeMillis;
    }
}