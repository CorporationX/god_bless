package school.faang.cachecache;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        return super.getWeatherData(city, maxCacheAgeMillis);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        checkMaxAgeCache(maxCacheAgeMillis);
        long timestamp = data.timestamp();
        long timeNow = System.currentTimeMillis();
        return maxCacheAgeMillis < (timeNow - timestamp);
    }

    @Override
    public void clearExpiredCache(long maxCacheAgeMillis) {
        super.clearExpiredCache(maxCacheAgeMillis);
    }

    @Override
    public void checkMaxAgeCache(long maxCacheAgeMillis) {
        super.checkMaxAgeCache(maxCacheAgeMillis);
    }
}