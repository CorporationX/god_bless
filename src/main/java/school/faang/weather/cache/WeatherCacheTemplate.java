package school.faang.weather.cache;

import school.faang.weather.model.WeatherData;
import school.faang.weather.service.WeatherProvider;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    protected WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = weatherProvider.fetchWeatherData(city);
            cache.put(city, data);
        }
        return data;
    }

    protected void forceUpdateWeather(String city) {
        WeatherData data = weatherProvider.fetchWeatherData(city);
        cache.put(city, data);
    }
}
