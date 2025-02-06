package school.faang;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> weatherInCity = new HashMap<>();

    public abstract WeatherData getWeatherData(String city, long maxCacheAgeMillis);

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public abstract void updateWeatherData(String city);
}
