package school.faang.task_44821;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {
    protected final HashMap<City, WeatherData> weatherCache = new HashMap<>();

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