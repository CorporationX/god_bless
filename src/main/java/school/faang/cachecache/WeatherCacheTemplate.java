package school.faang.cachecache;

import java.util.HashMap;
import java.util.Map;

abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> cache = new HashMap<>();
    private WeatherProvider provider;

    public WeatherCacheTemplate(WeatherProvider provider) {
        this.provider = provider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (cache.containsKey(city)) {
            WeatherData data = cache.get(city);
            if (!isCacheExpired(data, maxCacheAgeMillis)) {
                return data;
            }
        }
        return updateWeatherData(city);
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    private WeatherData updateWeatherData(String city) {
        WeatherData newData = provider.fetchWeatherData(city);
        cache.put(city, newData);
        return newData;
    }
}

