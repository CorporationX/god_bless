package school.faang.cachecache;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        return super.getWeatherData(city, maxCacheAgeMillis);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        checkMaxAgeCache(maxCacheAgeMillis);
        return true;
    }

    @Override
    public void checkMaxAgeCache(long maxCacheAgeMillis) {
        super.checkMaxAgeCache(maxCacheAgeMillis);
    }

    @Override
    public void clearExpiredCache(long maxCacheAgeMillis) {
        super.clearExpiredCache(maxCacheAgeMillis);
    }
}