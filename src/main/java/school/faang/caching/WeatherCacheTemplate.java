package school.faang.caching;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    protected Map<String, WeatherData> cityWeatherData = new HashMap<>();
    protected WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherService weatherService) {
        this.weatherProvider = weatherService;
    }

    protected WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cityWeatherData.get(city);
        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            weatherData = updateWeatherData(city);
            cityWeatherData.put(city, weatherData);
        }
        return weatherData;
    }

    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }

    protected WeatherData updateWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }

    protected void clearExpiredCache(long maxCacheAgeMillis) {
        Iterator<Map.Entry<String, WeatherData>> weatherDataIterator = cityWeatherData.entrySet().iterator();
        while (weatherDataIterator.hasNext()) {
            if (isTimeToCleanCache(weatherDataIterator.next().getValue(), maxCacheAgeMillis)) {
                weatherDataIterator.remove();
            }
        }
    }

    private boolean isTimeToCleanCache(WeatherData weatherData, long maxCacheAgeMillis) {
        return weatherData == null || System.currentTimeMillis() - weatherData.getTimestamp() > maxCacheAgeMillis;
    }
}
