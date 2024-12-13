package school.faang.sprint1.bjs_44850;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city) {
        if (city == null || city.isEmpty()) {
            throw new NullPointerException("Название города введено некорректно!");
        }

        if (!isCacheValid(city)) {
            updateWeatherData(city);
        }

        return cache.get(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry ->
            System.currentTimeMillis() - entry.getValue().getTimestamp() > maxCacheAgeMillis
        );
    }

    protected abstract boolean isCacheValid(String city);

    protected abstract void updateWeatherData(String city);
}
