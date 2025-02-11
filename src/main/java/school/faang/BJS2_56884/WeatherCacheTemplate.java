package school.faang.BJS2_56884;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    @Getter
    protected final Map<String, WeatherData> cache = new HashMap<>();
    WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            return updateWeatherData(city);
        }
        return data;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData updateWeatherData(String city) {
        WeatherData data = weatherProvider.fetchWeatherData(city);
        cache.put(city, data);
        return data;
    }
}
