package school.faang.cashecashe.main;

import school.faang.cashecashe.maincode.WeatherData;
import school.faang.cashecashe.maincode.WeatherMockService;
import school.faang.cashecashe.maincode.WeatherService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    private static WeatherMockService weatherService = new WeatherMockService();


    public static void main(String[] args) {
        System.out.println(WeatherService.getWeather("Machachkala", weatherCache, weatherService));
        System.out.println(WeatherService.getWeather("Kizlyar", weatherCache, weatherService));
        System.out.println(WeatherService.getWeather("Machachkala", weatherCache, weatherService));

        WeatherService.updateWeather("Kizlyar", weatherCache, weatherService);
        System.out.println(WeatherService.getWeather("Kizlyar", weatherCache, weatherService));

        WeatherService.removeWeather("Machachkala", weatherCache);

        System.out.println(WeatherService.getAllCity(weatherCache));
    }
}