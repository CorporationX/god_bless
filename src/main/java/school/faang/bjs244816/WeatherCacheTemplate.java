package school.faang.bjs244816;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {
    public HashMap<String, WeatherData> weatherDataLog;

    public void getWeatherData(String city, long maxCacheAgeMillis) {
        if (weatherDataLog == null || weatherDataLog.get(city) == null) {
            WeatherProvider.fetchWeatherData(city);
        }
    }

    private boolean checkTtl(long lastCallTime) {
        return true;
    }

    private void clearExpiredCache(long maxCacheAgeMillis){

    }
}
