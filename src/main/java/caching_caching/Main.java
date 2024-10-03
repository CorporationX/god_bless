package caching_caching;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    @Getter
    private static final Map<String, WeatherData> weatherData = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getWeather("London"));

        updateWeatherData("London");
        System.out.println(getWeather("London"));

        System.out.println(getWeather("Paris"));

        deleteWeatherData("Paris");
        System.out.println(getWeather("London"));

        printAllWeatherData();
    }

    public static WeatherData getWeather(String city) {
        WeatherData data = weatherData.get(city);
        if (data != null) {
            return data;
        }

        ApiWeather apiWeather = new ApiWeather();
        data = apiWeather.getWeatherData(city);
        weatherData.put(city, data);
        return data;
    }

    public static void updateWeatherData(String city) {
        ApiWeather apiWeather = new ApiWeather();
        weatherData.put(city, apiWeather.getWeatherData(city));
    }

    public static void deleteWeatherData(String city) {
        weatherData.remove(city);
    }

    public static void printAllWeatherData() {
        for (Map.Entry<String, WeatherData> entry : weatherData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
