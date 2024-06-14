package faang.school.godbless.weather;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherData = new HashMap<>(Map.of(
            "Berlin", new WeatherData("Berlin", 23.5, 74),
            "London", new WeatherData("London", 18.4, 88),
            "New York", new WeatherData("New York", 30, 44),
            "Antalya", new WeatherData("Antalya", 48.5, 20)
    ));

    public static void main(String[] args) {
        System.out.println(getWeather("Dubai"));
        System.out.println(getWeather("Berlin"));
        getAllCitiesWeather(weatherData);
        removeWeatherData("Antalya");

    }

    public static WeatherData getWeather(String city) {
        if (!weatherData.containsKey(city)) {
            return weatherData.put(city, WeatherData.MockWeather.getMockWeather());
        } else {
            return weatherData.get(city);
        }
    }

    public static void removeWeatherData(String city) {
        weatherData.remove(city);
    }

    public static void refreshWeatherData(String city, double temperature, int humidity) {
        weatherData.replace(city, new WeatherData(city, temperature, humidity));
    }

    public static void getAllCitiesWeather(Map<String, WeatherData> map) {
        map.forEach((key, value) -> {
            System.out.println("City: " + key + " - Weather: " + value);
        });

    }
}
