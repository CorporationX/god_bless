package faang.school.godbless;

import faang.school.godbless.Weather.WeatherData;

import java.util.*;

public class Application {
    public static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public static WeatherData getWeatherData(String city) {
        if (weatherDataMap.containsKey(city)) {
            return weatherDataMap.get(city);
        } else {
            WeatherData weatherData = weatherCity(city);
            weatherDataMap.put(city, weatherData);
            return weatherData;
        }
    }

    public static  WeatherData weatherCity(String city) {
        double temperature = Math.random() * 30;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }

    public static void updateWeatherData(String city, double temperature, double humidity) {
        WeatherData weatherData = new WeatherData(city, temperature, humidity);
        weatherDataMap.put(city, weatherData);
    }

    public static void removeWeatherData(String city) {
        weatherDataMap.remove(city);
    }

    public static  Set<String> getAllCities() {
        return weatherDataMap.keySet();
    }



    public static void main(String[] args) {
        System.out.println(getWeatherData("Moscow"));
        System.out.println(getWeatherData("Vladikavkaz"));
        System.out.println(getWeatherData("Moscow")); // Должно быть получено из кэша

        updateWeatherData("Moscow", 20.5, 75.0);
        System.out.println(getWeatherData("Moscow"));

        removeWeatherData("Vladikavkaz");
        System.out.println(getAllCities());
    }
}