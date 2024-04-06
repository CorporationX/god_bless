package faang.school.godbless.weather_forecast;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();

    public static void main(String[] args) {
        updateInfoWeatherData("New York");
        updateInfoWeatherData("Berlin");
        updateInfoWeatherData("Istambul");

        System.out.println(getWeather("New York"));
        System.out.println(getWeather("Berlin"));
        System.out.println(getWeather("Istambul"));

        removeWeatherData("Berlin");

        showAllCitiesInCache();
    }

    public static void removeWeatherData(String city) {
        weatherCache.remove(city);
    }

    public static void updateInfoWeatherData(String city) {
        weatherCache.put(city, new WeatherData(city, 22, 77));
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
        WeatherService weatherService = new WeatherService();
        WeatherData weatherData = weatherService.getWeatherService(city);
        if (weatherData != null) {
            weatherCache.put(city, weatherData);
        }
        return weatherData;
    }
}


