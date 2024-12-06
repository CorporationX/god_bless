package school.faang.caching_caching;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {
    static HashMap<String, WeatherData> weatherCache = new HashMap<>();
    WeatherProvider provider;

    public WeatherCacheTemplate(WeatherProvider provider) {
        this.provider = provider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (!weatherCache.containsKey(city)) {
            System.out.println(city + " cache not found");
            forceCacheUpdate(city);
        }
        if (isCacheExpired(weatherCache.get(city), maxCacheAgeMillis)) {
            forceCacheUpdate(city);
        }
        return weatherCache.get(city);
    };

    protected void forceCacheUpdate(String city) {
        weatherCache.put(city, provider.fetchWeatherData(city));
        System.out.println("Cache updated: " + city);
    };

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherCache.entrySet().removeIf(entry ->
                entry.getValue().getTimestamp() + maxCacheAgeMillis < System.currentTimeMillis());
        System.out.println("all expired cache was removed");
    }
    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);
}
