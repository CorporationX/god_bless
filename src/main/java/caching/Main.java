package caching;

import java.util.HashMap;
import java.util.Random;

public class Main {

    private static final HashMap<String, WeatherData> cache = new HashMap<>();

    public static void main(String[] args) {
        //Информации нет в кэше
        System.out.println(getWeatherInCity("London"));
        System.out.println(getWeatherInCity("Paris"));

        //Информация есть в кэше
        System.out.println(getWeatherInCity("London"));
        System.out.println(getWeatherInCity("Paris"));
    }

    public static WeatherData getWeatherInCity(String city) {
        if (cache.containsKey(city)) {
            System.out.println("Информация есть в кэше!");
            return cache.get(city);
        } else {
            System.out.println("Информации нет в кэше, запрашиваем!");
            WeatherData fetchedWeatherData = fetchWeatherData(city);
            cache.put(city, fetchedWeatherData);
            return fetchedWeatherData;
        }
    }

    private static WeatherData fetchWeatherData(String city) {
        Random rnd = new Random();
        return new WeatherData(city, rnd.nextDouble(), rnd.nextDouble());
    }
}
