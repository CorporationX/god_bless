package dima.evseenko.weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeatherService {
    private final Map<String, WeatherData> cachedWeatherData = new HashMap<>();

    public WeatherData getWeatherData(String city) {
        return cachedWeatherData.computeIfAbsent(city, WeatherRepository::getWeather);
    }

    public void updateWeatherData(String city) {
        if (Objects.nonNull(city)) {
            cachedWeatherData.put(city, WeatherRepository.getWeather(city));
        }
    }

    public void deleteWeatherData(String city) {
        cachedWeatherData.remove(city);
    }

    public WeatherData getCachedWeatherData(String city) {
        return cachedWeatherData.get(city);
    }

    public void printCachedWeatherData() {
        cachedWeatherData.forEach(((s, weatherData) -> System.out.println(weatherData)));
        System.out.println();
    }
}
