package school.faang.bjs2_56865;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherCache = new HashMap<>();
    private final WeatherProvider provider;

    WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.provider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (!weatherCache.containsKey(city) || isCacheExpired(weatherCache.get(city), maxCacheAgeMillis)) {
            updateWeatherData(city);
        }
        return weatherCache.get(city);
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    protected void updateWeatherData(String city) {
        WeatherData data = provider.fetchWeatherData(city);
        if (data != null) {
            weatherCache.put(city, data);
        } else {
            throw new IllegalStateException("Provided weather data does not exist: " + city);
        }
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        weatherCache.entrySet().removeIf(entry -> isCacheExpired(entry.getValue(), maxCacheAgeMillis));
    }

    public Map<String, WeatherData> getWeatherCache() {
        return Collections.unmodifiableMap(weatherCache);
    }
}
