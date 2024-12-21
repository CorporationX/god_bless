package derschrank.sprint01.task11.bjstwo_44817;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate implements WeatherCache {

    private static final long MAX_CACHE_AGE_MILLIS_DEFAULT = 1000L;

    private final long maxCacheAgeMillis;
    private final Map<String, WeatherData> cityWeatherDataCacheMap;
    private final WeatherProvider provider;

    public WeatherCacheTemplate() {
        this(MAX_CACHE_AGE_MILLIS_DEFAULT);
    }

    public WeatherCacheTemplate(long maxCacheAgeMillis) {
        this.maxCacheAgeMillis = maxCacheAgeMillis;
        provider = new WeatherService();
        cityWeatherDataCacheMap = new HashMap<>();
    }

    public WeatherData getWeatherData(String city) {
        return getWeatherData(city, maxCacheAgeMillis);
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cityWeatherDataCacheMap.get(city);
        if (isCacheNullOrExpired(data, maxCacheAgeMillis)) {
            data = getFreshWeatherDataAndUpdateInMap(city);
        }
        return data;
    }

    protected abstract boolean isCacheNullOrExpired(WeatherData data, long maxCacheAgeMillis);


    protected void clearExpiredCache(long maxCacheAgeMillis) {
        cityWeatherDataCacheMap.entrySet().removeIf(entry -> isCacheNullOrExpired(entry.getValue(), maxCacheAgeMillis));
    }

    protected WeatherData getFreshWeatherDataAndUpdateInMap(String city) {
        WeatherData data = provider.fetchWeatherData(city);
        cityWeatherDataCacheMap.put(city, data);
        return data;
    }
}
