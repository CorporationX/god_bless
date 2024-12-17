package school.faang.wecachwecachbjs44833;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {
    HashMap<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis){
        WeatherData data = cache.get(city);
        if (data != null && isDataFresh(data, maxCacheAgeMillis)){
            return data;
        }

        WeatherData freshData = fetchFreshWeatherData(city);
        cache.put(city, freshData);
        return freshData;
    }

    protected abstract WeatherData fetchFreshWeatherData(String city);

    protected boolean isDataFresh(WeatherData data, long maxCacheAgeMillis){
        return (System.currentTimeMillis() - data.getTimestamp() < maxCacheAgeMillis);
    }

    public void clearExpiredCache(long maxCacheAgeMilles){
        cache.entrySet().removeIf(entry -> !isDataFresh(entry.getValue(), maxCacheAgeMilles));
    }
}
