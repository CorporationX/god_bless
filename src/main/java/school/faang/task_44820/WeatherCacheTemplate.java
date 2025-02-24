package school.faang.task_44820;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public final WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cache.get(city);
        if (data != null && isCacheValid(data, maxCacheAgeMillis)) {
            System.out.println("took from cache");
            return cache.get(city);
        } else {
            System.out.println("NOT cache");
            WeatherData weatherData = updateWeatherData(city);
            cache.put(city, weatherData);
            return weatherData;
        }
    }

    public abstract boolean isCacheValid(WeatherData weatherData, long maxCacheAgeMillis);

    public abstract WeatherData updateWeatherData(String city);

    public void clearExpiredCache(long maxCacheAgeMillis) {
        long current = System.currentTimeMillis();
        Iterator<Map.Entry<String, WeatherData>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WeatherData> entry = iterator.next();
            if ((current - entry.getValue().getTimestamp()) > maxCacheAgeMillis) {
                iterator.remove();
            }
        }

    }
}
