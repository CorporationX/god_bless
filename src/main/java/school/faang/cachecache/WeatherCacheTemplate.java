package school.faang.cachecache;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        checkNameCity(city);
        checkMaxAgeCache(maxCacheAgeMillis);
        if (cache.containsKey(city)) {
            if (isCacheExpired(cache.get(city), maxCacheAgeMillis)) {
                String update = updateWeatherData(city);
                System.out.print(update);
            }
        } else {
            WeatherProvider weatherProvider = new WeatherService();
            cache.put(city, weatherProvider.fetchWeatherData(city));
            log.info("Город {} успешно добавлен в кэш", city);
        }
        return cache.get(city);
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public String updateWeatherData(String city) {
        checkNameCity(city);
        WeatherProvider weatherProvider = new WeatherService();
        WeatherData newWeatherData = weatherProvider.fetchWeatherData(city);
        cache.put(city, newWeatherData);
        return "Данные о погоде в " + city + " успешно обновлены\n";
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        checkMaxAgeCache(maxCacheAgeMillis);
        long currentTime = System.currentTimeMillis();
        cache.entrySet().removeIf(entry ->
                (currentTime - entry.getValue().timestamp()) > maxCacheAgeMillis);
    }

    private void checkNameCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Название города не может быть пустым");
        }
    }

    void checkMaxAgeCache(long maxCacheAgeMillis) {
        if (maxCacheAgeMillis <= 0) {
            throw new IllegalArgumentException("Максимальный срок хранения не может быть меньше 0");
        }
    }
}