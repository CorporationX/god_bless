package faang.school.godbless.java.sql.cache;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, WeatherData> weatherDataMap = new HashMap<>();
        weatherDataMap.computeIfAbsent("Kassel", k -> new WeatherData()).setAllParams("Kassel", 14, 60);
        weatherDataMap.computeIfAbsent("Hamburg", k -> new WeatherData()).setAllParams("Hamburg", 10, 99);

        WeatherAPI weatherAPI = new WeatherAPI();

        printWeatherInfoByCity("Moscow", weatherDataMap, weatherAPI);
        printWeatherInfoByCity("Tallinn", weatherDataMap, weatherAPI);
        printWeatherInfoByCity("Spb", weatherDataMap, weatherAPI);
        printWeatherInfoByCity("Izhevsk", weatherDataMap, weatherAPI);
        printWeatherInfoByCity("Kassel", weatherDataMap, weatherAPI);
        printWeatherInfoByCity("Hamburg", weatherDataMap, weatherAPI);
        updateWeather(weatherDataMap, "Hamburg",7, 97);
        removeCityWeather(weatherDataMap, "Spb");

        System.out.println(weatherDataMap);
    }

    public static void printWeatherInfoByCity(String city, Map<String, WeatherData> weatherDataMap, WeatherAPI weatherAPI) {
        WeatherData weatherData = weatherDataMap.computeIfAbsent(city, k -> weatherAPI.getWeatherData(city));
        System.out.println(weatherData);
    }

    public static void updateWeather(Map<String, WeatherData> weatherDataMap, String city, float temperature, float humidity) {
        weatherDataMap.computeIfAbsent(city, k -> weatherDataMap.get(city)).setAllParams(city, temperature, humidity);
    }

    public static void removeCityWeather(Map<String, WeatherData> weatherDataMap, String city) {
        weatherDataMap.remove(city);
    }
}
