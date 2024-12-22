package school.faang.bjs244816;

import lombok.Getter;
import java.util.HashMap;

@Getter
public abstract class WeatherCacheTemplate {
    private final HashMap<String, WeatherData> weatherDataLog = new HashMap<>();
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
