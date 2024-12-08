package school.faang.task_44819;

import lombok.Getter;

import java.util.HashMap;

@Getter
public abstract class WeatherCacheTemplate {
    private HashMap<String, WeatherData> weatherCache = new HashMap<>();
    private WeatherProvider weatherService = new WeatherService();

    public WeatherCacheTemplate(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

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
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        weatherCache.put(city, weatherData);
    }
}