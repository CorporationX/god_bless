package school.faang.task_44824;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private final Map<City, WeatherData> weatherCache = new HashMap<>();
    private final WeatherProvider weatherService;

    public WeatherCacheTemplate(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public WeatherData getWeatherData(City city) {
        weatherCache.putIfAbsent(city, weatherService.fetchWeatherData(city));
        WeatherData weatherData = weatherCache.get(city);

        if (isActualData(weatherData) == false) {
            weatherData = updateWeatherCache(city);
        }

        return weatherData;
    }

    protected abstract boolean isActualData(WeatherData weatherData);

    private WeatherData updateWeatherCache(City city) {
        weatherCache.remove(city);
        return weatherCache.put(city, weatherService.fetchWeatherData(city));
    }
}
