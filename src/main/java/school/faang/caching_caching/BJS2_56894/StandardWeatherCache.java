package school.faang.caching_caching.BJS2_56894;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardWeatherCache extends WeatherCacheTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandardWeatherCache.class);

    public StandardWeatherCache() {
        super(new WeatherService());
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        if (data == null) {
            LOGGER.warn("Cache expired: data is null");
            return true;
        }
        return (System.currentTimeMillis() - data.timestamp()) > maxCacheAgeMillis;
    }
}
