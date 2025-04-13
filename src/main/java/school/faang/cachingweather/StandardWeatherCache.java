package school.faang.cachingweather;

public class StandardWeatherCache extends WeatherCacheTemplate {
    long maxCacheAgeMillis = 6000;

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long cacheAgeMillis = System.currentTimeMillis() - data.getTimestamp();
        if (maxCacheAgeMillis < cacheAgeMillis) {
            return true;
        } else {
            return false;
        }
    }
}
