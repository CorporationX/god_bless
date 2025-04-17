package school.faang.cashcash;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cacheWeather = new HashMap<>();
    private final WeatherProvider weatherProvider = new WeatherService();

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis );

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cacheWeather.get(city);
        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return forceUpdateWeather(city);
        }
        return weatherData;
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherProvider provider = new WeatherService();
        WeatherData newData = provider.fetchWeatherData(city);
        cacheWeather.put(city, newData);
        return newData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        for (Map.Entry<String, WeatherData> entry : cacheWeather.entrySet()) {
            if (isCacheExpired(entry.getValue(), maxCacheAgeMillis)) {
                cacheWeather.remove(entry.getKey());
            }
        }
    }
}