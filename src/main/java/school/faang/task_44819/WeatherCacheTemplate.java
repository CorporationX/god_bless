package school.faang.task_44819;

import lombok.Getter;

import java.util.HashMap;

@Getter
public abstract class WeatherCacheTemplate {
    private HashMap<String, WeatherData> weatherCache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        boolean isContains = weatherCache.containsKey(city);
        if (isContains) {
            if (!isCacheExpired(weatherCache.get(city), maxCacheAgeMillis)) {
                return weatherCache.get(city);
            } else {
                updateWeatherData(city);
                return weatherCache.get(city);
            }
        } else {
            WeatherService weatherService = new WeatherService();
            weatherCache.put(city, weatherService.fetchWeatherData(city));
            return weatherCache.get(city);
        }
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        weatherCache.values().removeIf(time -> currentTime - time.getTimestamp() > maxCacheAgeMillis);
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public void updateWeatherData(String city) {
        WeatherService weatherService = new WeatherService();
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        weatherCache.put(city, weatherData);
    }
}