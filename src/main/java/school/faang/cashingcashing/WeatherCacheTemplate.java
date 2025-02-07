package school.faang.cashingcashing;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> weathersDataCache = new HashMap<>();

    public abstract WeatherData getWeatherData(String city, long maxCacheAgeMillis);

    protected boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        if (weathersDataCache.containsKey(weatherData.getCity())) {
            long timestampCache = weathersDataCache.get(weatherData.getCity()).getTimestamp();
            return timestampCache + maxCacheAgeMillis <= System.currentTimeMillis();
        }
        return true;
    }

    protected void updateWeatherData(String city) {
        WeatherService weatherService = new WeatherService();
        weathersDataCache.put(city, weatherService.fetchWeatherData(city));
    }
}
