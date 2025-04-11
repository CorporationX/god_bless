package school.faang.bjs2_68842;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
public abstract class WeatherCacheTemplate {
    private final Map<City, WeatherData> weatherInfo = new HashMap<>();
    private final WeatherServiceImpl weatherService;

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(City city, long maxCacheAgeMillis) {
        WeatherData weatherData = weatherInfo.get(city);
        if (Objects.isNull(weatherData) || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            weatherData = forceUpdateWeather(city);
        }
        return weatherData;
    }

    private WeatherData forceUpdateWeather(City city) {
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        weatherInfo.put(city, weatherData);
        return weatherData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherInfo.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }
}
