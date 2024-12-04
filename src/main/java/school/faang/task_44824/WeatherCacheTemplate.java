package school.faang.task_44824;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Map<City, WeatherData> weatherCache = new HashMap<>();
    private final WeatherService weatherService;

    public WeatherCacheTemplate(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public WeatherData getWeatherData(City city) {
        weatherCache.putIfAbsent(city, weatherService.fetchWeatherData(city));
        WeatherData weatherData = weatherCache.get(city);

        if (isActualData(weatherData) == false) {
            updateWeatherCache(city);
        }

        return weatherCache.get(city);
    }

    protected abstract boolean isActualData(WeatherData weatherData);

    private void updateWeatherCache(City city) {
        weatherCache.remove(city);
        weatherCache.put(city, weatherService.fetchWeatherData(city));
    }
}
