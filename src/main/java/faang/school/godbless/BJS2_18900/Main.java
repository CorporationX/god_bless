package faang.school.godbless.BJS2_18900;

import lombok.Data;

import java.util.*;

@Data
public class Main {
    private Map<String, WeatherData> cache;
    private MockWeatherService weatherService;

    public Main() {
        this.weatherService = new MockWeatherService();
        this.cache = new HashMap<>();
        cache.put("Москва", new WeatherData("Москва", 20.0, 70.0));
        cache.put("Сочи", new WeatherData("Сочи", 30.0, 65.0));
    }

    public WeatherData getWeatherInfo(String city) {
        if (cache.containsKey(city)) {
            return cache.get(city);
        } else {
            WeatherData weatherData = weatherService.getWeather(city);
            cache.put(city, weatherData);
            return weatherData;
        }
    }

    public void updateWeatherInfo(String city, WeatherData newWeatherData) {
        cache.put(city, newWeatherData);
    }

    public void deleteWeatherInfo(String city) {
        cache.remove(city);
    }

    public void getAllCitiesWeatherInfo() {
        cache.keySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main getWeather = new Main();

        System.out.println("Получение информации о погоде для Москвы:");
        System.out.println(getWeather.getWeatherInfo("Москва"));

        System.out.println("Получение информации о погоде для Сочи:");
        System.out.println(getWeather.getWeatherInfo("Сочи"));
        System.out.println("Получение информации о погоде для Самары:");
        System.out.println(getWeather.getWeatherInfo("Самара"));

        System.out.println("Обновление информации о погоде для Сочи:");
        WeatherData sochiWeather = new WeatherData("Сочи", 35.3, 45.7);
        getWeather.updateWeatherInfo("Сочи", sochiWeather);
        System.out.println(getWeather.getWeatherInfo("Сочи"));

        System.out.println("Удаление информации о погоде для Москвы:");
        getWeather.deleteWeatherInfo("Москва");

        System.out.println("Все города, для которых доступна информация о погоде:");
        getWeather.getAllCitiesWeatherInfo();
    }
}
