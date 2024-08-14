package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, WeatherData> weatherCacheMap = new HashMap<>();

    public static void main(String[] args) {
        weatherCacheMap.put("City", new WeatherData("City", 25, 50));
        weatherCacheMap.put("City1", new WeatherData("City1", 35, 30));
        weatherCacheMap.put("City2", new WeatherData("City2", 30, 60));
        weatherCacheMap.put("City3", new WeatherData("City3", 40, 55));

        System.out.println(getWeatherInfo("City"));

        System.out.println(getWeatherInfo("ity"));

        updateWeatherInfo("City3", 41, 56);

        removeWeatherInfo("City");

        printAllWeatherInfo();
    }

    public static WeatherData getWeatherInfo(String city) {
        if (!weatherCacheMap.containsKey(city)) {
            weatherCacheMap.put(city, new WeatherData(city, Mock.doWork(city), Mock.doWork(city)));
            Mock.doWork(city);
        }

        return weatherCacheMap.get(city);
    }

    public static void updateWeatherInfo(String city, int temperature, int humidity) {
        System.out.println(weatherCacheMap.put(
                city, new WeatherData(city, temperature, humidity)));
    }

    public static void removeWeatherInfo(String city) {
        weatherCacheMap.remove(city);
    }

    public static void printAllWeatherInfo() {
        for (Map.Entry<String, WeatherData> entry : weatherCacheMap.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println("Key > " + entry.getKey() + " - value > " + entry.getValue());
            }
        }
    }
}
