package faang.school.godbless.cachecache;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, WeatherData> WEATHER_DATA_CACHE = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("add weather data");
        WEATHER_DATA_CACHE.put("Saint-P", new WeatherData("Saint-P", 1, 80));
        WEATHER_DATA_CACHE.put("Sochi", new WeatherData("Sochi", 12, 82));
        WEATHER_DATA_CACHE.put("Moscow", new WeatherData("Moscow", 3, 75));
        printAllWeatherData();
        System.out.println("-----------------------------");
        System.out.println();

        System.out.println("Test getWeatherData Moscow");
        System.out.println(getWeatherData("Moscow"));
        System.out.println("-----------------------------");
        System.out.println();

        System.out.println("test updateWeatherData Sochi 11 79");
        updateWeatherData("Sochi", new WeatherData("Sochi", 11, 79));
        System.out.println("-----------------------------");
        System.out.println();

        System.out.println("test deleteWeatherData Saint-P");
        deleteWeatherData("Saint-P");
        System.out.println("-----------------------------");
        System.out.println();

        System.out.println("test getWeatherData Viborg");
        getWeatherData("Viborg");
        System.out.println("-----------------------------");
        System.out.println();

        printAllWeatherData();
    }

    public static WeatherData getWeatherData(String city) {
        return WEATHER_DATA_CACHE.computeIfAbsent(city, key -> MockWeatherService.getWeatherData());
    }

    public static void updateWeatherData(String city, WeatherData weatherData) {
        WEATHER_DATA_CACHE.put(city, weatherData);
    }

    public static void deleteWeatherData(String city) {
        WEATHER_DATA_CACHE.remove(city);
    }

    public static void printAllWeatherData() {
        WEATHER_DATA_CACHE.forEach((key, value) -> System.out.println(value));
    }
}
