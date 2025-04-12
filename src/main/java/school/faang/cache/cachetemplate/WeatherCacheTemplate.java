package school.faang.cache.cachetemplate;

import lombok.Getter;
import school.faang.cache.WeatherData;
import school.faang.cache.WeatherProvider;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> cityWeathers;
    private final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.cityWeathers = new HashMap<>();
        this.weatherProvider = weatherProvider;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public final WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = cityWeathers.get(city);
        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = weatherProvider.fetchWeatherData(city);
            cityWeathers.put(city, data);
        }
        return data;
    }

    public final WeatherData forceUpdateWeather(String city) {
        WeatherData data = weatherProvider.fetchWeatherData(city);
        cityWeathers.put(city, data);
        return data;
    }

    public final boolean clearExpiredCache(long maxCacheAgeMillis) {
        return cityWeathers.entrySet().removeIf(data -> this.isCacheExpired(data.getValue(), maxCacheAgeMillis));
    }
}