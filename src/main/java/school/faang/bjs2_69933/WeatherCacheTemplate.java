package school.faang.bjs2_69933;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> weatherByCity = new HashMap<>();
    private WeatherProvider weatherProvider = new WeatherService();

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (!weatherByCity.containsKey(city)) {
            forceUpdateWeather(city);
        }
        if (isCacheExpired(weatherByCity.get(city), maxCacheAgeMillis)) {
            forceUpdateWeather(city);
        }
        return weatherByCity.get(city);
    }

    public WeatherData forceUpdateWeather(String city) {
        weatherByCity.put(city, weatherProvider.fetchWeatherData(city));
        return weatherProvider.fetchWeatherData(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        for (Map.Entry<String, WeatherData> entry : weatherByCity.entrySet()) {
            if (System.currentTimeMillis() - entry.getValue().getTimestamp() > maxCacheAgeMillis) {
                weatherByCity.remove(entry.getKey());
            }
        }
    }
}
