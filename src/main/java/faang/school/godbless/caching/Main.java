package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WeatherDataService weatherDataService = new WeatherDataService();
        Map<String, WeatherData> weatherCache = new HashMap<>();

        weatherCache.put("Seoul", new WeatherData("Seoul", 17, 75));
        weatherCache.put("Bangkok", new WeatherData("Bangkok", 33, 60));
        weatherCache.put("Istanbul", new WeatherData("Istanbul", 24, 72));

        weatherCache.values().forEach(System.out::println);
        System.out.println();

        weatherDataService.getWeatherDataForCity(weatherCache, "Istanbul");
        weatherDataService.getWeatherDataForCity(weatherCache, "London");
        System.out.println();

        weatherDataService.updateWeatherData(weatherCache, "Bangkok");

        weatherDataService.removeWeatherData(weatherCache, "Seoul");

        weatherDataService.weatherInfoForAllCities(weatherCache);
    }
}
