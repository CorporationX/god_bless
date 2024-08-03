package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static Map<String, WeatherData> weatherDataMap;

    public static void main(String[] args) {
        weatherDataMap = new HashMap<>();

        weatherDataMap.put("Seoul", new WeatherData("Seoul", 17, 75));
        weatherDataMap.put("Bangkok", new WeatherData("Bangkok", 33, 60));
        weatherDataMap.put("Istanbul", new WeatherData("Istanbul", 24, 72));

        weatherDataMap.values().forEach(System.out::println);
        System.out.println();

        getWeatherDataForCity("Istanbul");
        getWeatherDataForCity("London");
        System.out.println();

        updateWeatherData("Bangkok");

        removeWeatherData("Seoul");

        weatherInfoForAllCities();
    }

    public static void getWeatherDataForCity(String city) {
        weatherDataMap.computeIfAbsent(city, Main::getRandomWeatherData);
        System.out.println(weatherDataMap.get(city).getCity() +
                " Temperature: " + weatherDataMap.get(city).getTemperature() +
                " Humidity: " + weatherDataMap.get(city).getHumidity()
        );
    }

    private static WeatherData getRandomWeatherData(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(-20, 50), random.nextInt(0, 90));
    }

    public static void updateWeatherData(String city) {
        weatherDataMap.put(city, getRandomWeatherData(city));
    }

    public static void removeWeatherData(String city) {
        weatherDataMap.remove(city);
    }

    public static void weatherInfoForAllCities() {
        weatherDataMap.forEach((key, value) -> {
            if (key != null) {
                System.out.println(key +
                        " Temperature: " + value.getTemperature() +
                        " Humidity: " + value.getHumidity());
            }
        });
    }
}
