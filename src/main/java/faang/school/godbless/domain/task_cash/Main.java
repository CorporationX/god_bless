package faang.school.godbless.domain.task_cash;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, WeatherData> weatherCash = new HashMap<>();
    private static WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {


    }

    public static String infoWeather(String city) {
        if (weatherCash.containsKey(city)) {
            return weatherCash.get(city).toString();
        } else {
            WeatherData weatherData = weatherService.getService(city);
            weatherCash.put(city, weatherData);
            return weatherData.toString();
        }
    }

    public static void updateInfoWeather(String city, Double temperature, Double humidity) {
        weatherCash.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void removeWeather(String city) {
        weatherCash.remove(city);
    }

    public static void printCityCash(Map<String, WeatherData> weatherCash) {
        for (Map.Entry<String, WeatherData> entry : weatherCash.entrySet()) {
            System.out.println("город-" + entry.getKey() + " info: " + entry.getValue());
        }
    }
}

