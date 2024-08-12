package BJS2_18987;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> weatherCache = new HashMap<>();

        weatherCache.put("Moscow", new WeatherData("Moscow", 22.3, 45.4));
        weatherCache.put("Paris", new WeatherData("Paris", 19.3, 70.2));
        weatherCache.put("Warsaw", new WeatherData("Warsaw", 31.3, 49.1));
        weatherCache.put("Berlin", new WeatherData("Berlin", 25.7, 42.4));
        weatherCache.put("London", new WeatherData("London", 29.3, 55.9));
        WeatherData weatherDataTest = new WeatherData("Berlin", 15.1, 10.5);
        //Get weather by city
        printWeather("Saint-Petersburg", weatherCache);

        //Update weather in chosen city
        updateWeather(weatherDataTest.getCity(), weatherCache, weatherDataTest);

        //Remove weatherData ignoring removing the city
        removeWeatherData(weatherDataTest.getCity(), weatherCache);

        //Print all weatherData
        printAllCitiesWeather(weatherCache);
    }

    public static void printWeather(String city, Map<String, WeatherData> weather) {
        weather.computeIfAbsent(city, key -> WeatherTestAPI.getWeather(city));
        System.out.println("The temperature in " + city + " " + weather.get(city).getTemperature()
                + " and humidity is " + weather.get(city).getHumidity());
    }

    public static void updateWeather(String city, Map<String, WeatherData> weather, WeatherData weatherData) {
        weather.put(city, weatherData);
        System.out.println(weatherData.getCity() + " " + weatherData.getTemperature() + " " + weatherData.getHumidity());
    }

    public static void removeWeatherData(String city, Map<String, WeatherData> weather) {
        weather.remove(city);
        System.out.println(city + " removed");
    }

    public static void printAllCitiesWeather(Map<String, WeatherData> weather) {
        for (Map.Entry<String, WeatherData> entry : weather.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println(entry.getKey() + " " + entry.getValue().getTemperature() + " " + entry.getValue().getHumidity());
            }
        }
    }

}
