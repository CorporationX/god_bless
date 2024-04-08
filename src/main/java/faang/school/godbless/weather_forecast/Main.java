package faang.school.godbless.weather_forecast;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    private static WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        updateInfoWeatherData("New York", 23, 75);
        updateInfoWeatherData("Berlin", 26, 60);
        updateInfoWeatherData("Istambul", 32, 80);

        System.out.println(getWeather("New York"));
        System.out.println(getWeather("Berlin"));
        System.out.println(getWeather("Istambul"));

        removeWeatherData("Berlin");

        showAllCitiesInCache();

        System.out.println(getWeather("LA"));
    }

    public static void removeWeatherData(String city) {
        weatherCache.remove(city);
    }

    public static void updateInfoWeatherData(String city, int temperature, int humidity) {
        weatherCache.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void showAllCitiesInCache() {

        for (String city : weatherCache.keySet()) {
            System.out.println(city);
        }
    }

    public static WeatherData getWeather(String city) {
        if (weatherCache.containsKey(city)) {
            return weatherCache.get(city);
        }

        WeatherData weatherData = weatherService.getWeatherData(city);
        if (weatherData != null) {
            weatherCache.put(city, weatherData);
        }
        return weatherData;
    }
}


