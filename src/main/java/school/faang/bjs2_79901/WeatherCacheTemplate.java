package school.faang.bjs2_79901;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    @Getter
    private final Map<String, WeatherData> weatherByCity = new HashMap<>();

    @Setter
    WeatherProvider weatherProvider;

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData currentData = weatherByCity.get(city);
        if (isCacheExpired(currentData, maxCacheAgeMillis)) {
            forceUpdateWeather(city);
        }
        return currentData;
    }

    public void forceUpdateWeather(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        weatherByCity.put(city, newData);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherByCity.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }

}