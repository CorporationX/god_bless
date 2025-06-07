package school.faang.cache_cache;

import school.faang.util.DatesUtil;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return DatesUtil.isExpired(weatherData.getTimestamp(), maxCacheAgeMillis);
    }
}
