package school.faang.sprint.first.cachingcaching.service;

import school.faang.sprint.first.cachingcaching.model.WeatherData;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData existWeatherData = weatherDataMap.get(city);

        if (existWeatherData == null
                || isCacheExpired(existWeatherData, maxCacheAgeMillis)) {
            WeatherData updatedWeatherData = updateWeatherData(city);
            weatherDataMap.put(city, updatedWeatherData);

            return updatedWeatherData;
        }

        return existWeatherData;
    }

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    abstract WeatherData updateWeatherData(String city);
}
