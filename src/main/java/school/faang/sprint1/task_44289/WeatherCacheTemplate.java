package school.faang.sprint1.task_44289;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    private final Map<String, WeatherData> cache = new HashMap<>();
    private final WeatherProvider weatherProvider = new WeatherService();

    protected final WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData foundWeatherData = cache.get(city);
        if (foundWeatherData == null || isDateExpired(city, maxCacheAgeMillis)) {
            WeatherData weatherData = weatherProvider.fetchWeatherData(city);
            updateWeatherData(city, weatherData);
            return weatherData;
        }
        return foundWeatherData;
    }

    private boolean isDateExpired(String city, long maxCacheAgeMillis) {
        WeatherData foundWeatherData = cache.get(city);
        if (foundWeatherData == null) {
            return true;
        }
        return System.currentTimeMillis() - foundWeatherData.getTimestamp() > maxCacheAgeMillis;
    }

    private void updateWeatherData(String city, WeatherData weatherData) {
        cache.put(city, weatherData);
    }

    public void removeExpiredWeatherData(long maxCacheAgeMillis) {
        List<WeatherData> listOfExpiredWeatherData = new ArrayList<>();
        for (WeatherData weatherData : cache.values()) {
            if (System.currentTimeMillis() - weatherData.getTimestamp() > maxCacheAgeMillis) {
                listOfExpiredWeatherData.add(weatherData);
            }
        }
        // to avoid concurrency
        for (WeatherData weatherData : listOfExpiredWeatherData) {
            cache.remove(weatherData.getCity());
        }
    }

    public abstract WeatherData fetchWeatherData(String city);
}
