package school.faang.bjs2_79779;


import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherCacheByCity = new HashMap<>();
    private WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = weatherCacheByCity.get(city);

        if (weatherData != null && !isCacheExpired(weatherData, maxCacheAgeMillis)) {
            WeatherData newWeatherData = forceUpdateWeather(city);
            if (newWeatherData != null) {
                weatherData = newWeatherData;
            }
        }

        return weatherData;
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        if (weatherData != null) {
            weatherCacheByCity.put(city, weatherData);
        }

        return weatherData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherCacheByCity.entrySet()
                .removeIf((pair) -> isCacheExpired(pair.getValue(), maxCacheAgeMillis));
    }
}
