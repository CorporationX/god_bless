package bsj286005;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    Map<String, WeatherData> weatherCash = new HashMap<>();
    WeatherProvider weatherProvider;

    long maxCacheAgeMillis;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (weatherCash.get(city) == null || isCacheExpired(weatherCash.get(city), maxCacheAgeMillis)) {
            weatherCash.put(city, forceUpdateWeather(city));
        }
        return weatherCash.get(city);
    }

    public WeatherData forceUpdateWeather(String city) {
        return weatherProvider.fetchWeatherData(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        weatherCash.entrySet().removeIf(entry -> (currentTime - entry.getValue().getTimestamp()) > maxCacheAgeMillis);
    }
}
