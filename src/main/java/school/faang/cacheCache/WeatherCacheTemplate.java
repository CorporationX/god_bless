package school.faang.cacheCache;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> cityMap = new HashMap<>();
    WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cityMap.get(city);
        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
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
            cityMap.put(city, weatherData);
        }

        return weatherData;
    }

}
