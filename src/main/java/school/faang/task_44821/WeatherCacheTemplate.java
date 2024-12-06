package school.faang.task_44821;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private final Map<City, WeatherData> weatherCache = new HashMap<>();

    public WeatherData getWeatherData(City city) {
        if (!isCacheValid(city)) {
            updateWeatherData(city);
        }
        return weatherCache.get(city);
    }

    protected abstract boolean isCacheValid(City city);

    protected abstract void updateWeatherData(City city);

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherCache.entrySet().removeIf(entry ->
                (System.currentTimeMillis() - entry.getValue().getTimestamp()) > maxCacheAgeMillis
        );
    }
}