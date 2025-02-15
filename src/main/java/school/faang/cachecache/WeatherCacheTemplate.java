package school.faang.cachecache;

import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный класс который, хранит данные о погоде.
 * Использует паттерн "Шаблонный метод".
 * Основным шаблоном является метод getWeatherData
 */
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider provider;

    public WeatherCacheTemplate(WeatherProvider provider) {
        this.provider = provider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (cache.containsKey(city)) {
            WeatherData weatherData = cache.get(city);
            if (!isCacheExpired(weatherData, maxCacheAgeMillis)) {
                return weatherData;
            }
        }
        return updateWeatherData(city);
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    private WeatherData updateWeatherData(String city) {
        WeatherData newData = provider.fetchWeatherData(city);
        cache.put(city, newData);
        return newData;
    }

}
