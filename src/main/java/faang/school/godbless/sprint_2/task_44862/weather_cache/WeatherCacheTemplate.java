package faang.school.godbless.sprint_2.task_44862.weather_cache;

import faang.school.godbless.sprint_2.task_44862.WeatherData;
import faang.school.godbless.sprint_2.task_44862.WeatherService;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherData = new HashMap<>();
    private final WeatherService weatherService = new WeatherService();

    public abstract boolean isExpired(String city, Long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, Long maxCacheAgeMillis) {
        if (isExpired(city, maxCacheAgeMillis)) {
            weatherData.put(city, weatherService.fetchWeatherData(city));
        }
        return weatherData.get(city);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        List<String> citiesWithOutdatedWeatherData = new ArrayList<>();
        weatherData.forEach((key, value) -> {
            if (System.currentTimeMillis() - value.getTimestamp() > maxCacheAgeMillis) {
                citiesWithOutdatedWeatherData.add(key);
            }
        });
        citiesWithOutdatedWeatherData.forEach(weatherData::remove);
    }
}
