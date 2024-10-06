package school.faang.main_code_cash_cash;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    private static WeatherService weatherService = new WeatherService();


    public static void main(String[] args) {
        System.out.println(getWeather("Machachkala"));
        System.out.println(getWeather("Kizlyar"));
        System.out.println(getWeather("Machachkala"));

        updateWeather("Kizlyar");
        System.out.println(getWeather("Kizlyar"));

        removeWeather("Machachkala");

        System.out.println(getAllCity());
    }

    public static WeatherData getWeather(String city) {
        if (weatherCache.containsKey(city)) {
            return weatherCache.get(city);
        }
        WeatherData weatherData = weatherService.getWeatherData(city);
        weatherCache.put(city, weatherData);
        return weatherData;
    }

    public static void updateWeather(String city) {
        WeatherData updateWeatherData = weatherService.getWeatherData(city);
        weatherCache.put(city, updateWeatherData);
    }

    public static void removeWeather(String city) {
        weatherCache.remove(city);
    }

    public static String getAllCity() {
        return weatherCache.keySet().toString();
    }
}
