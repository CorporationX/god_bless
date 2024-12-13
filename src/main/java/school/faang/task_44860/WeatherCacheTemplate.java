package school.faang.task_44860;

import lombok.Getter;
import lombok.NonNull;
import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cachedWeather = new HashMap<>();
    private final WeatherService weatherService = new WeatherService();

    public WeatherData getWeatherData(@NonNull String city) {
        if (cachedWeather.containsKey(city)) {
            if (!isCacheExpired(city)) {
                System.out.println("Data from cache");
                return cachedWeather.get(city);
            }
        }
        System.out.println("Data from service");
        return refreshCache(city);
    }

    protected abstract boolean isCacheExpired(String city);

    protected abstract void clearExpiredCache();

    private WeatherData refreshCache(@NonNull String city) {
        WeatherData weather = weatherService.fetchWeatherData(city);
        cachedWeather.put(city, weather);
        return weather;
    }
}
