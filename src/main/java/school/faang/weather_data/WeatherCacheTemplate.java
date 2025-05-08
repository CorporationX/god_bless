package school.faang.weather_data;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider weatherProvider;

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);

        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = weatherProvider.fetchWeatherData(city);
            cache.put(city, data);
        }

        return data;
    }

    public void forceUpdateWeather(String city) {
        cache.put(city, weatherProvider.fetchWeatherData(city));
    }
}