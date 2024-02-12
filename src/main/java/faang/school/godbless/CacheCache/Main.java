package faang.school.godbless.CacheCache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> WEATHER_DATA = new HashMap<>();
    private static final MockClass MOCK_DATA = new MockClass();

    public static void main(String[] args) {
        System.out.println(getInfoWeather("Kazan"));
        System.out.println(getInfoWeather("Surgut"));
        getAllInfoWeather();
        removeInfoWeather("Surgut");
        updateInfoWeather("Kazan");
        System.out.println("______________");
        getAllInfoWeather();
    }

    public static WeatherData getInfoWeather(String city) {
        WeatherData weatherData = WEATHER_DATA.get(city);
        if (weatherData == null) {
            weatherData = MOCK_DATA.getData(city);
            WEATHER_DATA.put(city, weatherData);
        }
        return weatherData;
    }

    public static void updateInfoWeather(String city) {
        WEATHER_DATA.put(city, MOCK_DATA.getData(city));
    }

    public static void removeInfoWeather(String city) {
        WEATHER_DATA.remove(city);
    }

    public static void getAllInfoWeather() {
        WEATHER_DATA.forEach((city, weatherData) -> System.out.println(weatherData.toString()));
    }
}
