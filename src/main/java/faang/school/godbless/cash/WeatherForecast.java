package faang.school.godbless.cash;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class WeatherForecast {
    private final Map<String, WeatherData> forecasts = new HashMap<>();

    public void updateCache(String city) {
        WeatherData data = WeatherService.getForecast(city);
        forecasts.put(city, data);
    }

    public void clearCache(String city) {
        forecasts.remove(city);
    }

    public WeatherData getForecast(String city) {
        if (!forecasts.containsKey(city)) {
            //presuming that weather service is reliable and always returns data
            updateCache(city);
        }
        return forecasts.get(city);
    }
}
