package school.faang.bjs2_86050;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> weatherCache = new HashMap<>();
    private WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider provider) {
        this.weatherProvider = provider;
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = weatherCache.get(city);

        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = weatherProvider.fetchWeatherData(city);
            weatherCache.put(city, data);
        }

        return data;
    }
}
