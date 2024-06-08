package faang.school.godbless.BJS2_8656;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, WeatherData> weatherCache = new HashMap<>();

    public static void main(String[] args) {
        WeatherData moscow = new WeatherData("Moscow", 20, 25);
        WeatherData amsterdam = new WeatherData("Amsterdam", 25, 40);
        WeatherData berlin = new WeatherData("Berlin", 15, 45);
        WeatherData london = new WeatherData("London", 18, 55);

        weatherCache.put(moscow.getCity(), moscow);
        weatherCache.put(amsterdam.getCity(), amsterdam);
        weatherCache.put(berlin.getCity(), berlin);
        weatherCache.put(london.getCity(), london);

        printWeatherCacheCities();
        System.out.println(getWeather("London"));

        deleteWeatherCache("London");
        printWeatherCacheCities();

        System.out.println(getWeather("Izhevsk"));

        refreshWeatherCache("Izhevsk", new WeatherData("Izhevsk", 99, 99));
        printWeatherCacheCities();

        System.out.println(getWeather("Izhevsk"));
    }

    public static WeatherData getWeather(String city) {
        boolean isPresentInCache = weatherCache.containsKey(city);
        if (isPresentInCache) {
            return weatherCache.get(city);
        } else {
            DataBase dataBase = new DataBase();
            WeatherData weatherData = dataBase.getWeatherData(city);
            weatherCache.put(city, weatherData);
            return weatherData;
        }
    }

    public static void refreshWeatherCache(String city, WeatherData weatherData) {
        if (city != null && weatherData != null) {
            if (weatherCache.containsKey(city)) {
                weatherCache.put(city, weatherData);
            }
        }
    }

    public static void deleteWeatherCache(String city) {
        if (city != null) {
            weatherCache.remove(city);
        }
    }

    public static void printWeatherCacheCities() {
        System.out.println("Список закешированных городов:");
        for (Map.Entry<String, WeatherData> entry : weatherCache.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
