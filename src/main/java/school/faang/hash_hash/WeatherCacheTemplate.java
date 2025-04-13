package school.faang.hash_hash;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    private final Map<String, WeatherData> weatherDataMap = new HashMap<>();

    private WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }


    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        weatherDataMap.computeIfAbsent(city, newCity -> weatherProvider.fetchWeatherData(city));

        if (isCacheExpired(weatherDataMap.get(city), maxCacheAgeMillis)) {
            forceUpdateWeather(city);
        }
        return weatherDataMap.get(city);
    }

    void forceUpdateWeather(String city) {
        weatherDataMap.put(city, weatherProvider.fetchWeatherData(city));
    }


}
