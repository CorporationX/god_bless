package school.faang.service;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class WeatherCacheTemplate {
    private WeatherProvider weatherProvider;
    private Map<String, WeatherData> weatherData = new HashMap<>();

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cachedData = weatherData.get(city);
        if (cachedData == null || isCacheExpired(cachedData, maxCacheAgeMillis)) {
            return updateWeatherData(city);
        }
        return cachedData;
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    protected WeatherData updateWeatherData(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        weatherData.put(city, newData);
        return newData;
    }
}