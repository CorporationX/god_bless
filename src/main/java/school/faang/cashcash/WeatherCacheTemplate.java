package school.faang.cashcash;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cacheWeather = new HashMap<>();
    private WeatherProvider weatherProvider;

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public abstract WeatherProvider getWeatherData(String city, long maxCacheAgeMillis);

    public void forceUpdateWeather(String city) {


    }


}
