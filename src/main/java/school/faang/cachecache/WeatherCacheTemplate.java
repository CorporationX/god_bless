package school.faang.cachecache;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        checkNameCity(city);
        checkMaxAgeCache(maxCacheAgeMillis);
        if (cache.containsKey(city)) {
            boolean isExpired = isCacheExpired(cache.get(city), maxCacheAgeMillis);
            if (isExpired) {
                String update = updateWeatherData(city);
                System.out.print(update);
            }
        } else {
            WeatherProvider weatherProvider = new WeatherService();
            cache.put(city, weatherProvider.fetchWeatherData(city));
            System.out.println("Город " + city + " успешно добавлен в кэш");
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
                (currentTime - entry.getValue().getTimestamp()) > maxCacheAgeMillis);
    }

    public void checkNameCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Название города не может быть пустым");
        }
    }

    public void checkMaxAgeCache(long maxCacheAgeMillis) {
        if (maxCacheAgeMillis <= 0) {
            throw new IllegalArgumentException("Максимальный срок хранения не может быть меньше 0");
        }
    }
}