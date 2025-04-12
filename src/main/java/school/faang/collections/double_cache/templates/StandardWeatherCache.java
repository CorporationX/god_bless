package school.faang.collections.double_cache.templates;

import school.faang.collections.double_cache.provider.WeatherData;
import school.faang.collections.double_cache.provider.WeatherService;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache() {
        super(new WeatherService());
    }

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - weatherData.timestamp() > maxCacheAgeMillis;
    }
}