package dima.evseenko.weather;

import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    private final Map<String, WeatherData> cachedWeatherData = new HashMap<>();

    public WeatherData getWeatherData(String city) {
        return cachedWeatherData.computeIfAbsent(city, WeatherRepository::getWeather);
    }

    public void updateWeatherData(String city) {
        validateCity(city);

        cachedWeatherData.put(city, WeatherRepository.getWeather(city));
    }

    public void deleteWeatherData(String city) {
        cachedWeatherData.remove(city);
    }

    public WeatherData getCachedWeatherData(String city) {
        return cachedWeatherData.get(city);
    }

    private void validateCity(String city) {
        if(city == null)
            throw new IllegalArgumentException("city is null");
    }

    public void printCachedWeatherData() {
        cachedWeatherData.forEach(((s, weatherData) -> System.out.println(weatherData)));
        System.out.println();
    }
}
