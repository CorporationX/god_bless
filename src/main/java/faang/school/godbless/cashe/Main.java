package faang.school.godbless.cashe;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> cache = new HashMap<>();
        cache.put("New York", new WeatherData("New York", 21, 50));
        cache.put("Orlando", new WeatherData("Orlando", 11, 70));
        System.out.println(getWeatherInfo(cache, "New York"));
        System.out.println(getWeatherInfo(cache, "Riga"));
        System.out.println(getWeatherInfo(cache, "Riga"));
        updateWeatherInfo(cache, "Riga");
        System.out.println(getWeatherInfo(cache, "Riga"));
        System.out.println("============>>>>>>>>>>>>>>>>>>>>");
        printWeatherInfo(cache);
    }

    public static WeatherData getWeatherInfo(Map<String, WeatherData> cache, String city) {
        if (cache.containsKey(city)) {
            System.out.println("Информация о погоде для города " + city + " найдена в кэше");
            return cache.get(city);
        } else {
            System.out.println("Запрос информации о погоде для города " + city + " к внешнему источнику");
            ExternalService externalService = new ExternalService();
            WeatherData weatherData = externalService.getWeather(city);
            cache.put(city, weatherData);
            return weatherData;
        }
    }

    public static void updateWeatherInfo(Map<String, WeatherData> cache, String city) {
        if (cache.containsKey(city)) {
            System.out.println("Обновление информации о погоде для города " + city);
            ExternalService externalService = new ExternalService();
            WeatherData updatedWeatherData = externalService.getWeather(city);
            cache.put(city, updatedWeatherData);
            System.out.println("Информация о погоде для города " + city + " обновлена");
        } else {
            System.out.println("Информация о погоде для города " + city + " не найдена в кэше");
        }
    }

    public static void printWeatherInfo(Map<String, WeatherData> cache) {
        System.out.println("Города с информацией о погоде в кэше:");
        for (String city : cache.keySet()) {
            System.out.println(city);
        }
    }
}
