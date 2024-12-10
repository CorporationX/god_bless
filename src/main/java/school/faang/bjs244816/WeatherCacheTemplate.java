package school.faang.bjs244816;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {
    protected HashMap<String, WeatherData> weatherDataLog = new HashMap<>();
    private final WeatherService weatherService = new WeatherService();

    public WeatherData getWeatherData(String city) {
        WeatherData cachedData = weatherDataLog.get(city);

        if (cachedData == null || !checkTtl(cachedData.getTimestamp())) {
            WeatherData newData = weatherService.fetchWeatherData(city);
            weatherDataLog.put(city, newData);
            return newData;
        }
        return cachedData;
    }

    abstract boolean checkTtl(long lastCallTime);

    abstract void clearExpiredCache();
}
