package cachecache;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected Map<String, WeatherData> weatherData = new HashMap<>();
    protected WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cached = weatherData.get(city);

        if (cached != null && !isCacheExpired(cached, maxCacheAgeMillis)) {
            return cached;
        }

        WeatherData newData = weatherProvider.fetchWeatherData(city);
        weatherData.put(city, newData);
        return newData;
    }

    public void forceUpdateWeather(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        weatherData.put(city, newData);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherData.entrySet()
                .removeIf(e -> System.currentTimeMillis() - e.getValue().getTimestamp() > maxCacheAgeMillis);
    }
}
