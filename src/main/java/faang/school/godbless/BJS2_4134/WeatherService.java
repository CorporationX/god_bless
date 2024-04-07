package faang.school.godbless.BJS2_4134;

import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    private final Map<String, WeatherData> weatherCache;

    public WeatherService() {
        weatherCache = new HashMap<>();
    }

    private static WeatherData getMockWeatherData(String city) {
        double temperature = Math.random() * 100;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }

    public WeatherData getWeatherByCity(String city) {
        if (weatherCache.containsKey(city)) {
            return weatherCache.get(city);
        }

        WeatherData weatherData = getMockWeatherData(city);
        weatherCache.put(city, weatherData);

        return weatherData;
    }

    public void updateWeatherByCity(String city, WeatherData newWeatherData) {
        weatherCache.put(city, newWeatherData);
    }

    public void removeWeatherByCity(String city) {
        weatherCache.remove(city);
    }

    public void printCachedCities() {
        System.out.println("Список городов с доступной информацией о погоде в кэше:");
        for (String city : weatherCache.keySet()) {
            System.out.println(city);
        }
    }
}
