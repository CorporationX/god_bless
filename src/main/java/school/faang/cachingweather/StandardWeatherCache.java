package school.faang.cachingweather;

import lombok.Getter;

@Getter
public class StandardWeatherCache extends WeatherCacheTemplate {
    private long maxCacheAgeMillis;

    public StandardWeatherCache() {
        super();
        this.maxCacheAgeMillis = 6000;
    }

    @Override
    public boolean isCacheExpired(WeatherData data) {
        long cacheAgeMillis = System.currentTimeMillis() - data.getTimestamp();
        if (this.getMaxCacheAgeMillis() < cacheAgeMillis) {
            return true;
        } else {
            return false;
        }
    }
}
