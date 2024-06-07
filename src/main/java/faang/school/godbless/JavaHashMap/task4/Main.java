package faang.school.godbless.JavaHashMap.task4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CITY_TO_WEATHER = new HashMap<>();

    public static void main(String[] args) {
        addCity("Москва", new WeatherData("Москва", 20, 45));
        addCity("Тамбов", new WeatherData("Тамбов", 22, 50));
        addCity("Саратаов", new WeatherData("Саратов", 30, 49));
        printAll();
        updateWeatherByCity("Москва", 11, 11);
        removeCacheByCity("Саратаов");
        printAll();
        getWeatherCity("Саратаов");


    }

    public static void getWeatherCity(String city) {
        WeatherData weatherData = CITY_TO_WEATHER.get(city);
        if (weatherData != null) {
            System.out.println(city + " " + weatherData.getTemperature() + "С' " + weatherData.getHumidity() + "%");
        } else {
            weatherData = MockWeather.getMockWeather(city);
            System.out.println(city + " " + weatherData.getTemperature() + "С' " + weatherData.getHumidity() + "%");
        }
    }

    public static void addCity(String city, WeatherData weather) {
        CITY_TO_WEATHER.put(city, weather);
    }

    public static void updateWeatherByCity(String city, int temperature, int humidity) {
        WeatherData data = new WeatherData(city, temperature, humidity);
        CITY_TO_WEATHER.put(city, data);
    }

    public static void removeCacheByCity(String city) {
        CITY_TO_WEATHER.remove(city);
    }

    public static void printAll() {
        for (String city : CITY_TO_WEATHER.keySet()) {
            WeatherData weatherData = CITY_TO_WEATHER.get(city);
            System.out.println(city + " " + weatherData.getTemperature() + "С' " + weatherData.getHumidity() + "%");
        }
    }
}
