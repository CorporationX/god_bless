package school.faang.weathercache;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected static final Map<String, WeatherData> WEATHER_INFO = new HashMap<>();

    protected final WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = WEATHER_INFO.get(city);
        if (weatherData != null && !isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return weatherData;
        }
        return updateWeatherData(city);
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    protected WeatherData updateWeatherData(String city) {
        WeatherService weatherService = new WeatherService();
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        WEATHER_INFO.put(city, weatherData);
        return weatherData;
    }

    protected void clearExpiredCache(long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        var iterator = WEATHER_INFO.entrySet().iterator();

        while (iterator.hasNext()) {
            var entry = iterator.next();
            WeatherData weatherData = entry.getValue();

            if (currentTime - weatherData.timestamp() > maxCacheAgeMillis) {
                iterator.remove();
            }
        }
    }

}
