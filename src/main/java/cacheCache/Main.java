package cacheCache;

import cacheCache.services.WeatherService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CITY_WEATHER_DATA = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Проверка погоды в городах");
        CITY_WEATHER_DATA.put("London", new WeatherData("London", 20, 50));
        printWeatherData();
        System.out.println(getWeather("Moscow").toString());
        System.out.println(getWeather("Amsterdam").toString());

        System.out.println("\nПосле обновления погоды в городе London");
        updateWeatherDate("London");
        printWeatherData();

        System.out.println("\nПосле удаления погоды в городе Moscow");
        removeWeatherData("Moscow");
        removeWeatherData("Kiev");

        printWeatherData();

    }

    public static WeatherData getWeather(String city) {
        if (CITY_WEATHER_DATA.containsKey(city)) {
            return CITY_WEATHER_DATA.get(city);
        }
        WeatherData weatherData = WeatherService.getWeatherData(city);
        CITY_WEATHER_DATA.put(city, weatherData);
        return weatherData;
    }

    public static void updateWeatherDate(String city) {
        WeatherData weatherData = WeatherService.getWeatherData(city);
        CITY_WEATHER_DATA.put(city, weatherData);
    }

    public static void removeWeatherData(String city) {
        CITY_WEATHER_DATA.put(city, null);
    }

    public static void printWeatherData() {
        for (Map.Entry<String, WeatherData> entry : CITY_WEATHER_DATA.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }


}
