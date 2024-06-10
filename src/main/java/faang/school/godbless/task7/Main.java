package faang.school.godbless.task7;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CACHE = new HashMap<>();

    public static void main(String[] args) {
        CACHE.put("New York", new WeatherData("New York", 20.0F, 60.0F));
        CACHE.put("London", new WeatherData("London", 15.0F, 70.0F));

        updateWeatherData("New York", new WeatherData("New York", 22.0F, 55.0F));
        WeatherData moscowWeather = getWeatherDataByCityName("Moscow");
        System.out.println(moscowWeather);
        removeWeatherData("London");

        printCachedCities();
    }

    public static void updateWeatherData(String city, WeatherData weatherData) {
        CACHE.put(city, weatherData);
    }

    public static void removeWeatherData(String city) {
        CACHE.remove(city);
    }

    public static void printCachedCities() {
        System.out.println("Города в кэше:");
        for (String city : CACHE.keySet()) {
            System.out.println(city);
        }
    }

    public static WeatherData getWeatherDataByCityName(String city) {
        WeatherData weatherData;
        if (!CACHE.containsKey(city))
            CACHE.put(city, WeatherService.getWeatherByCityName(city));
        weatherData = CACHE.get(city);
        return weatherData;
    }

}
