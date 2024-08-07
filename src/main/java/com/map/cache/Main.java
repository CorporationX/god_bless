package com.map.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Main {
    private static final Map<String, WeatherData> WEATHER_DATA_MAP = new HashMap<>();

    public static void main(String[] args) {

        WeatherData spbWeather = new WeatherData("SPB", 23, 0.75);
        WeatherData moscowWeather = new WeatherData("Moscow", 25, 0.6);

        WEATHER_DATA_MAP.put(spbWeather.getCity(), spbWeather);
        WEATHER_DATA_MAP.put(moscowWeather.getCity(), moscowWeather);

        System.out.println("Получение погоды по городам\n"
                + getWeather("SPB") + "\n"
                + getWeather("Moscow") + "\n");

        spbWeather.setHumidity(0.68);
        spbWeather.setTemperature(23);
        System.out.println("Изменение погоды в городе "
                + spbWeather.getCity()
                + " Температура: "
                + spbWeather.getTemperature()
                + " Влажность: "
                + spbWeather.getHumidity() + "\n");

        update("SPB", spbWeather);
        System.out.println("Обновление данных о погоде в городе\n"
                + spbWeather.getCity()
                + " Температура: "
                + spbWeather.getTemperature()
                + " Влажность: "
                + spbWeather.getHumidity() + "\n");

        System.out.println("Получение данных о погоде:\n"
                + getWeather("SPB") + "\n");

        System.out.println("Удалить данные о погоде:\n"
        + spbWeather.getCity() + "\n");
        delete("SPB");

        System.out.println("Получение дынных о погоде во всех городах\n" + getAllWeather() + "\n");
        System.out.println("Получение данных о погоде:\n"
                + getWeather("SPB") + "\n");
    }

    public static WeatherData getWeather(String city) {
        return WEATHER_DATA_MAP.computeIfAbsent(city, v -> getInfoAboutWeather(city));
    }

    public static void update(String city, WeatherData weatherData) {
        WEATHER_DATA_MAP.replace(city, WEATHER_DATA_MAP.get(city), weatherData);
    }

    public static void delete(String city) {
        WEATHER_DATA_MAP.remove(city);
    }

    public static Map<String, WeatherData> getAllWeather() {
        return WEATHER_DATA_MAP;
    }

    public static WeatherData getInfoAboutWeather(String city) {
        return new WeatherData(city, 25, 0.53);
    }
}
