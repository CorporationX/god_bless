package school.faang.BJS2_86058;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider weatherProvider = new WeatherService();

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (cache.containsKey(city)) {
            WeatherData data = cache.get(city);
            if (!isCacheExpired(data, maxCacheAgeMillis)) {
                return data;
            }
        }
        WeatherData data = weatherProvider.fetchWeatherData(city);
        cache.put(city, data);
        return data;
    }

    public void forceUpdateWeather(String city) {
        cache.put(city, weatherProvider.fetchWeatherData(city));
    }
}
