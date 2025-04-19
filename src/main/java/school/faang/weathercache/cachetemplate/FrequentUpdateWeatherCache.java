package school.faang.weathercache.cachetemplate;

import school.faang.weathercache.WeatherData;
import school.faang.weathercache.WeatherProvider;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
