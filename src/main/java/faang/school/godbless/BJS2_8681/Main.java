package faang.school.godbless.BJS2_8681;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, WeatherData> cityWeather = new HashMap<>();

    public static void main(String[] args) {
        cityWeather.put("Moscow", new WeatherData("Moscow", 30, 50));
        cityWeather.put("Volgodonsk", new WeatherData("Volgodonsk", 35, 40));
        cityWeather.put("Tver", new WeatherData("Tver", 22, 30));
        printAllWeatherData();
        System.out.println();
        removeCity("Volgodonsk");
        printAllWeatherData();
        System.out.println();
        System.out.println(getWeatherInfo("Volgodonsk"));
        updateWeather("Moscow", new WeatherData("Moscow", 50, 60));
        System.out.println();
        printAllWeatherData();
    }

    public static WeatherData getWeatherInfo(String cityName) {
        if (!cityWeather.containsKey(cityName)) {
            cityWeather.put(cityName, MokClass.getWeather(cityName));
        }
        return cityWeather.get(cityName);
    }

    public static void updateWeather(String cityName, WeatherData weatherData) {
        cityWeather.put(cityName, weatherData);
    }

    public static void removeCity(String cityName) {
        cityWeather.remove(cityName);
    }

    public static void printAllWeatherData() {
        cityWeather.entrySet().forEach(entry -> System.out.println(entry.getValue()));
    }
}
