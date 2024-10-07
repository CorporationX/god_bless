package school.faang.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<String, WeatherData> cityToWeatherData = new HashMap<>();
    private final WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        Main main = new Main();
        String city1 = "Москва";
        String city2 = "Казань";
        String city3 = "Питер";

        main.update(city1);
        main.update(city2);
        main.update(city3);
        main.print();

        System.out.println(main.getWeather(city1));
        System.out.println();

        main.remove(city1);
        main.print();
    }

    public WeatherData getWeather(String cityName) {
        WeatherData weatherData = cityToWeatherData.getOrDefault(cityName, weatherService.getWeatherData(cityName));
        cityToWeatherData.put(cityName, weatherData);
        return weatherData;
    }

    public void update(String cityName) {
        WeatherData weatherData = weatherService.getWeatherData(cityName);
        cityToWeatherData.put(cityName, weatherData);
    }

    public void remove(String cityName) {
        cityToWeatherData.remove(cityName);
    }

    public void print() {
        cityToWeatherData.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();
    }
}
