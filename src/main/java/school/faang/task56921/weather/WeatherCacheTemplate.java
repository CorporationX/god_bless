package school.faang.task56921.weather;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> cityInfo = new HashMap<>();

    public abstract WeatherData getWeatherData(String city, long maxCacheAgeMillis);

    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return data.getTimestamp() + maxCacheAgeMillis < new Date().getTime();
    }

    public void updateWeatherData(String city) {
        WeatherService weatherService = new WeatherService();
        cityInfo.put(city, weatherService.fetchWeatherData(city));
    }
}
