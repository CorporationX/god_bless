package derschrank.task11.bjstwo_44817;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate implements WeatherCache {

    private static final long MAX_CACHE_AGE_MILLIS_DEFAULT = 1000L;
    private long maxCacheAgeMillis;

    Map<String, WeatherData> map;

    public WeatherCacheTemplate() {
        this(MAX_CACHE_AGE_MILLIS_DEFAULT);
    }

    public WeatherCacheTemplate(long maxCacheAgeMillis) {
        this.maxCacheAgeMillis = maxCacheAgeMillis;
        map = new HashMap<>();
    }

    public WeatherData getWeatherData(String city) {
        return getWeatherData(city, maxCacheAgeMillis);
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = map.get(city);
        if (isCacheNullOrExpired(data, maxCacheAgeMillis)) {
            data = getFreshWeatherDataAndUpdateInMap(city);
        }
        return data;
    }

    protected abstract boolean isCacheNullOrExpired(WeatherData data, long maxCacheAgeMillis);


    protected void clearExpiredCache(long maxCacheAgeMillis) {
        map.entrySet().removeIf(entry -> isCacheNullOrExpired(entry.getValue(), maxCacheAgeMillis));
    }

    protected WeatherData getFreshWeatherDataAndUpdateInMap(String city) {
        WeatherProvider provider = new WeatherService();
        WeatherData data = provider.fetchWeatherData(city);
        map.put(city, data);
        return data;
    }
}
