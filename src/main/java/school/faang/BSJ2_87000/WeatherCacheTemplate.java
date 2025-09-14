package school.faang.BSJ2_87000;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    Map<String, WeatherData> weatherDatas = new HashMap<>();
    WeatherProvider weatherProvider = new WeatherService();

    public abstract boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData;
        if ((weatherData = weatherDatas.get(city)) != null && !isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return weatherData;
        }
        weatherData = forceUpdateWeather(city);
        weatherDatas.put(city, weatherData);
        return weatherData;
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        weatherDatas.put(city, weatherData);
        return weatherData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherDatas.entrySet().removeIf(entry ->
                (System.currentTimeMillis() - entry.getValue().getTimestamp()) > maxCacheAgeMillis);
    }
}
