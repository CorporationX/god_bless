package faang.school.godbless.JavaHashMap.BJS2_8635;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(getWeather("Moscow"));
        System.out.println(getWeather("Piter"));
        System.out.println(getWeather("Kazan"));
        System.out.println();
        updateWeather("Moscow");
        System.out.println(getWeather("Moscow"));
        removeWeather("Moscow");
        System.out.println();
        System.out.println(getCities());
    }
    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    private static WeatherService weatherService = new WeatherService();

    public static WeatherData getWeather(String city) {
        if (weatherCache.containsKey(city)) {
            return weatherCache.get(city);
        } else {
            WeatherData weatherData = weatherService.getWeather(city);
            weatherCache.put(city, weatherData);
            return weatherData;
        }
    }

    public static void updateWeather(String city) {
        WeatherData weatherData = weatherService.getWeather(city);
        weatherCache.put(city, weatherData);
    }

    public static void removeWeather(String city) {
        weatherCache.remove(city);
    }

    public static Set<String> getCities() {
        return weatherCache.keySet();
    }
}

