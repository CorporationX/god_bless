package faang.school.godbless.cash;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class WeatherForecast {
    private final Map<String, WeatherData> forecastMap = new HashMap<>();

    public void updateCache(String city) {
        WeatherData data = WeatherService.getForecast(city);
        forecastMap.put(city, data);
    }

    public void removeFromCache(String city) {
        forecastMap.remove(city);
    }

    public WeatherData getForecast(String city) {
        if (!forecastMap.containsKey(city)) {
            updateCache(city);
        }
        return forecastMap.get(city);
    }
}
