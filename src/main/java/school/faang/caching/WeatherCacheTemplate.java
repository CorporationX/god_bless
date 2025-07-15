package school.faang.caching;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherData = new HashMap<>();
    private final WeatherProvider provider;

    public WeatherCacheTemplate(WeatherService provider) {
        this.provider = provider;
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = weatherData.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = forceUpdateWeather(city);
            weatherData.put(city, data);
        }
        return data;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherData.entrySet()
                .removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
        System.out.println("Кеш почищен");
    }

    private WeatherData forceUpdateWeather(String city) {
        WeatherData cash = provider.fetchWeatherData(city);
        weatherData.put(city, cash);
        System.out.printf("Данные по городу \"%s\" обновлены\n", city);
        return cash;
    }
}