package school.faang.weathercache;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        long cacheTime = currentTime - data.timestamp();

        return cacheTime > maxCacheAgeMillis;
    }
}
