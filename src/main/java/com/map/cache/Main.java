package com.map.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherInCity = new HashMap<>();
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData("SPB", 23, 0.75);
        weatherInCity.put("SPB", weatherData);

        System.out.println(getWeather("SPB"));
        System.out.println(getWeather("Moscow"));

        weatherData.setHumidity(0.68);
        weatherData.setTemperature(23);

        update("SPB", weatherData);

        System.out.println(getWeather("SPB"));

        delete("SPB");

        System.out.println(getWeather("SPB"));

        System.out.println(getWeather());
    }
    public static WeatherData getWeather (String city) {
        if(weatherInCity.containsKey(city)){
           return weatherInCity.get(city);
        } else {
            weatherInCity.put(city, getInfoAboutWeather(city));
            return weatherInCity.get(city);
        }
    }
    public static void update(String city, WeatherData weatherData) {
        weatherInCity.replace(city, weatherInCity.get(city), weatherData);
    }
    public static void delete (String city) {
        weatherInCity.remove(city);
    }
    public static Map<String, WeatherData> getWeather() {
        return weatherInCity;
    }
    public static WeatherData getInfoAboutWeather(String city) {
        return new WeatherData(city, 25, 0.53);
    }
}
