package school.faang.bjs2_79765;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> weatherInCity = new HashMap<>();
    protected final WeatherService weatherService;

    public WeatherCacheTemplate(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cacheData = weatherInCity.get(city);

        if (cacheData != null && !isCacheExpired(cacheData, maxCacheAgeMillis)) {
            return cacheData;
        }

        return updateWeatherData(city);
    }

    public WeatherData forceUpdateWeather(String city) {
        return updateWeatherData(city);
    }

    protected WeatherData updateWeatherData(String city) {
        WeatherData newData = weatherService.fetchWeatherData(city);
        weatherInCity.put(city, newData);
        return newData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherInCity.entrySet().removeIf(entry ->
                System.currentTimeMillis() - entry.getValue().getTimestamp() > maxCacheAgeMillis);
    }

}
