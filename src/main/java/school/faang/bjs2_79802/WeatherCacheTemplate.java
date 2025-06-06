package school.faang.bjs2_79802;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherData = new HashMap<>();
    private final WeatherProvider provider = new WeatherService();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = weatherData.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = forceUpdateWeather(city);
            weatherData.put(city, data);
        }
        return data;
    }

    private WeatherData forceUpdateWeather(String city) {
        return weatherData.put(city, provider.fetchWeatherData(city));
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

}
