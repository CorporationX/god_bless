package school.faang.caching_caching_bjs2_79820;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class WeatherCacheTemplate {
    private WeatherProvider weatherProvider;
    private Map<String, WeatherData> weatherDataCache = new HashMap<>();

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (weatherDataCache.containsKey(city)) {
            if (!isCacheExpired(weatherDataCache.get(city), maxCacheAgeMillis)) {
                return weatherDataCache.get(city);
            } else {
                WeatherData newData = weatherProvider.fetchWeatherData(city);
                weatherDataCache.put(city, newData);
                return newData;
            }
        } else {
            log.warn("Такого города нет");
            //Нормально ли вернуть null?
            return null;
        }
    }

    public void forceUpdateWeather(String city) {
        WeatherData newData = weatherProvider.fetchWeatherData(city);
        weatherDataCache.put(city, newData);
    }
}
