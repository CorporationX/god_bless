package school.faang.collections.double_cache.templates;

import school.faang.collections.double_cache.provider.WeatherData;
import school.faang.collections.double_cache.provider.WeatherService;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache() {
        super(new WeatherService());
    }

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return true;
    }
}