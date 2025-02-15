package school.faang.cachecache;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider weatherProvider;

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cacheData = cache.get(city);

        if (cacheData != null && !isCacheExpired(cacheData, maxCacheAgeMillis)) {
            System.out.println("Данные для города " + city + " получены из кэша.");
            return cacheData;
        }

        System.out.println("Данные для города " + city + " неактуальны. Обновление...");
        return updateWeatherData(city);
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData updateWeatherData(String city) {
        WeatherData freshData = weatherProvider.fetchWeatherData(city);
        cache.put(city, freshData);
        return freshData;
    }
}
