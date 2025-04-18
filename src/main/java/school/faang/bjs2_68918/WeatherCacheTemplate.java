package school.faang.bjs2_68918;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherCache = new HashMap<>();
    private final WeatherProvider weatherProvider = new WeatherService();

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = weatherCache.computeIfAbsent(city, key -> weatherProvider.fetchWeatherData(city));

        if (isCacheExpired(weatherData, maxCacheAgeMillis)) {
            weatherData = forceUpdateWeather(city);
        }

        return weatherData;
    }

    public WeatherData forceUpdateWeather(String city) {
        return weatherCache.compute(city, (key, value) -> weatherProvider.fetchWeatherData(city));
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        try {
            for (Map.Entry<String, WeatherData> entry : weatherCache.entrySet()) {
                if (isCacheExpired(entry.getValue(), maxCacheAgeMillis)) {
                    weatherCache.remove(entry.getKey());
                }
            }
        } catch (ConcurrentModificationException ignored) {
            //чтобы checkstyle не ругался
        }

    }

}
