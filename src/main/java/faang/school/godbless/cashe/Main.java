package faang.school.godbless.cashe;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> weather = new HashMap<>();
        weather.put("New York", new WeatherData("New York", 21, 50));
        weather.put("Orlando", new WeatherData("Orlando", 11, 70));
        System.out.println(getWeatherInfo(weather, "New York"));
        System.out.println(getWeatherInfo(weather, "Riga"));
        System.out.println(getWeatherInfo(weather, "Riga"));
        updateWeatherInfo(weather, "Riga");
        System.out.println(getWeatherInfo(weather, "Riga"));
        System.out.println("============>>>>>>>>>>>>>>>>>>>>");
        printWeatherInfo(weather);
    }

    public static WeatherData getWeatherInfo(Map<String, WeatherData> weather, String city) {
        if (weather.containsKey(city)) {
            System.out.println("Информация о погоде для города " + city + " найдена в кэше");
            return weather.get(city);
        } else {
            System.out.println("Запрос информации о погоде для города " + city + " к внешнему источнику");
            WeatherData weatherData = ExternalService.getWeather(city);
            weather.put(city, weatherData);
            return weatherData;
        }
    }

    static class ExternalService {
        public static WeatherData getWeather(String city) {
            int temperature = (int) (Math.random() * 55 - 25);
            int humidity = (int) (Math.random() * 51) + 40;
            return new WeatherData(city, temperature, humidity);
        }
    }

    public static void updateWeatherInfo(Map<String, WeatherData> weather, String city) {
        if (weather.containsKey(city)) {
            System.out.println("Обновление информации о погоде для города " + city);
            WeatherData updatedWeatherData = ExternalService.getWeather(city);
            weather.put(city, updatedWeatherData);
            System.out.println("Информация о погоде для города " + city + " обновлена");
        } else {
            System.out.println("Информация о погоде для города " + city + " не найдена в кэше");
        }
    }

    public static void printWeatherInfo(Map<String, WeatherData> weather) {
        System.out.println("Города с информацией о погоде в кэше:");
        for (String city : weather.keySet()) {
            System.out.println(city);
        }
    }
}
