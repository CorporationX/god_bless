package school.faang.bjs2_69933;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    Map<String, WeatherData> weatherCash = new HashMap<>();
    WeatherProvider weatherProvider = new WeatherService();

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (weatherCash.containsKey(city)) {
            if (isCacheExpired(weatherCash.get(city), maxCacheAgeMillis)) {
                //weatherCash.computeIfAbsent(city, k -> weatherProvider.fetchWeatherData(city));
                weatherCash.put(city, weatherProvider.fetchWeatherData(city));
            }
        }
        return weatherCash.get(city);
    }

    public WeatherData forceUpdateWeather(String city) {
        weatherCash.put(city, weatherProvider.fetchWeatherData(city));
        return weatherProvider.fetchWeatherData(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        for (Map.Entry<String, WeatherData> entry : weatherCash.entrySet()) {
            if (System.currentTimeMillis() - entry.getValue().getTimestamp() < maxCacheAgeMillis) {
                weatherCash.remove(entry.getKey());
            }
        }
    }
}
