package school.faang.BJS2_56884;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    private final Map<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = updateWeatherData(city);
            cache.put(city, data);
        }
        return data;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData updateWeatherData(String city) {
        WeatherProvider weatherService = new WeatherService();
        return weatherService.fetchWeatherData(city);
    }
}
