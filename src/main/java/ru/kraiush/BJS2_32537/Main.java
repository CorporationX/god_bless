package ru.kraiush.BJS2_32537;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> WEATHER_DATA = new HashMap<>();

    private static void getWeatherData(String city) {
        if (WEATHER_DATA.containsKey(city)) {
            System.out.println(WEATHER_DATA.get(city));
        } else {
            WEATHER_DATA.put(city, getWeatherDataFromDatabase(city));
            System.out.println(WEATHER_DATA.get(city));
        }
    }

    private static WeatherData getWeatherDataFromDatabase(String city) {
        return Database.getWeatherData(city);
    }

    private static void updateWeatherData(String city, int temperature, int humidity) {
        WeatherData weatherDataForUpdate = new WeatherData(city, temperature, humidity);
        WEATHER_DATA.put(city, weatherDataForUpdate);
    }

    private static void deleteWeatherDataOfCity(String city) {
        WEATHER_DATA.remove(city);
    }

    private static void getWeatherDataOfCities() {
        for (Map.Entry<String, WeatherData> entry : WEATHER_DATA.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        WeatherData london = new WeatherData("London", 10, 70);
        WeatherData losAngeles = new WeatherData("Los Angeles", 25, 50);
        WeatherData newYork = new WeatherData("New York", 18, 60);
        WeatherData sanFrancisco = new WeatherData("San Francisco", 20, 80);

        WEATHER_DATA.put("London", london);
        WEATHER_DATA.put("Los Angeles", losAngeles);
        WEATHER_DATA.put("New York", newYork);
        WEATHER_DATA.put("San Francisco", sanFrancisco);

        getWeatherData("Los Angeles");
        getWeatherData("Astana");

        updateWeatherData("New York", 20, 70);

        deleteWeatherDataOfCity("London");

        getWeatherDataOfCities();
    }
}
