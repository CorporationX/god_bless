package faang.school.godbless.BJS218910;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, WeatherData> weatherCache = new HashMap<>();

    public static void main(String[] args) {
        weatherCache.put("Msk", new WeatherData("Msk", 25, 40));
        weatherCache.put("Omsk", new WeatherData("Omsk", 18, 37));
        weatherCache.put("Tmn", new WeatherData("Tmn", 13, 20));
        weatherCache.put("Ekb", new WeatherData("Ekb", 15, 27));

        listAllCity();
        System.out.println(getCityWeather("Ekb"));
        System.out.println();

        deleteWeatherCache("Ekb");
        listAllCity();
        System.out.println();

        System.out.println(getCityWeather("San Francisco"));
    }

    public static WeatherData getCityWeather(String city) {
        return weatherCache.computeIfAbsent(city, keyCity -> MokClass.addStub(city));
    }

    public static void deleteWeatherCache(String city) {
        weatherCache.remove(city);
    }

    public static void listAllCity() {
        System.out.println(weatherCache.keySet());
    }
}

