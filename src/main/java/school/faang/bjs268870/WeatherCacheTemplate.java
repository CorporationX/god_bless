package school.faang.bjs268870;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    Map<String, WeatherData> cache = new HashMap<>();
    WeatherProvider weatherProvider = new WeatherService();

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cache.get(city);
        if (weatherData == null || isCacheExpired(cache.get(city), maxCacheAgeMillis)) {
            weatherData = weatherProvider.fetchWeatherData(city);
            cache.put(city, weatherData);
        }
        return weatherData;
    }

    public void forceUpdateWeather(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        cache.put(city, weatherData);
    }
}
