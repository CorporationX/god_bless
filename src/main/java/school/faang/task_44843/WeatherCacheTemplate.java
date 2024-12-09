package school.faang.task_44843;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final WeatherProvider weatherProvider = new WeatherService();
    @Getter
    protected HashMap<String, WeatherData> cache;

    public WeatherCacheTemplate() {
        this.cache = getInitialData();
    }

    protected abstract Boolean isExpired(WeatherData weatherData);

    protected WeatherData getWeatherData(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City don't be null!");
        }

        var weatherFromCache = getFromCache(city);

        if (weatherFromCache != null && !isExpired(weatherFromCache)) {
            return weatherFromCache;
        } else {
            var newWeatherData = weatherProvider.fetchWeatherData(city);
            updateCache(city, newWeatherData);

            return newWeatherData;
        }
    }

    protected void clearExpiredCache(long maxCacheAgeMillis) {
        cache.entrySet().removeIf(entry -> checkTime(entry.getValue(), maxCacheAgeMillis));
    }

    private WeatherData getFromCache(String city) {
        return cache.get(city);
    }

    private void updateCache(String city, WeatherData newWeatherData) {
        cache.put(city, newWeatherData);
    }

    protected static boolean checkTime(WeatherData weatherData, long maxCacheAgeMillis) {
        var currentTime = System.currentTimeMillis();

        return currentTime - weatherData.getTimestamp() > maxCacheAgeMillis;
    }

    private HashMap<String, WeatherData> getInitialData() {
        WeatherData weatherData1 = new WeatherData("Moscow");
        WeatherData weatherData2 = new WeatherData("Kazan");
        WeatherData weatherData3 = new WeatherData("LA");
        WeatherData weatherData4 = new WeatherData("New York");

        return new HashMap<>(Map.of(
            weatherData1.getCity(), weatherData1,
            weatherData2.getCity(), weatherData2,
            weatherData3.getCity(), weatherData3,
            weatherData4.getCity(), weatherData4
        ));
    }
}
