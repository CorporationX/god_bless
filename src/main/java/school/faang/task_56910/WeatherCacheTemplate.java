package school.faang.task_56910;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> mapWeatherData = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = mapWeatherData.get(city);
        if (weatherData != null && !isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return weatherData;
        }
        return updateWeatherData(city);
    }

    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }

    public WeatherData updateWeatherData(String city) {
        WeatherData weatherData = createWeatherProvider().fetchWeatherData(city);
        mapWeatherData.put(city, weatherData);
        return weatherData;
    }

    protected abstract WeatherProvider createWeatherProvider();
}
