package school.faang.cachecache;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> mapWeatherCity = new HashMap<>();
    private WeatherProvider weatherProvider = new WeatherService();

    public WeatherCacheTemplate() {
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public final WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = mapWeatherCity.get(city);
        if (data != null && isCacheExpired(data, maxCacheAgeMillis)) {
            return data;
        }
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);
        mapWeatherCity.put(city, weatherData);
        return weatherData;
    }

    public void forceUpdateWeather(String city) {
        mapWeatherCity.put(city, weatherProvider.fetchWeatherData(city));
    }

    public void print() {
        System.out.println(mapWeatherCity);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        mapWeatherCity.entrySet()
                .removeIf(entry -> (System.currentTimeMillis() - entry.getValue().timeStamp()) >= maxCacheAgeMillis);
    }
}
