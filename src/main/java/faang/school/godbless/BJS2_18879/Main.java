package faang.school.godbless.BJS2_18879;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> cityWeather = new HashMap<>();

    public static void main(String[] args) {
        cityWeather.put("Moscow", new WeatherData("Moscow", 24.5, 34));
        cityWeather.put("Warsaw", new WeatherData("Moscow", 24.5, 34));

        System.out.println(getCityWeather("Moscow"));
        System.out.println(getCityWeather("Toronto"));
        System.out.println(cityWeather);
    }

    public static WeatherData getCityWeather(String city){
        return cityWeather.computeIfAbsent(city, (x) -> WeatherAPI.getWeather(city));
    }
}
