package school.faang.cacheCache;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> cityMap = new HashMap<>();
    private WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cityMap.get(city);
        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            WeatherData newWeatherData = forceUpdateWeather(city);
            weatherData = newWeatherData;
        }

        return weatherData;
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        cityMap.put(city, weatherData);
        return weatherData;
    }

}
