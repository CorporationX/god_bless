package faang.school.godbless.bjs2_4331;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public static void main(String[] args) {

        WeatherData weatherData1 = new WeatherData("Moscow", 12, 30);
        WeatherData weatherData2 = new WeatherData("Kaliningrad", 15, 20);
        WeatherData weatherData3 = new WeatherData("Vladivostok", 22, 35);

        weatherDataMap.put("Moscow", weatherData1);
        weatherDataMap.put("Kaliningrad", weatherData2);
        weatherDataMap.put("Vladivostok", weatherData3);

        System.out.println(showCityWeather("Moscow"));
        //Update weather for Moscow
        updateWeatherData("Moscow", new WeatherData("Moscow", 15, 23));
        System.out.println("\nWeather for Moscow after cache update");
        System.out.println(showCityWeather("Moscow"));

        //Remove weather data for Moscow
        removeWeatherDataCity("Moscow");
        System.out.println("\nWeather for Moscow after remove from cache");
        System.out.println(showCityWeather("Moscow"));

        //Print all cities in cache
        System.out.println("\nPrint all cities in cache");
        printAllCityInWeatherCache();
    }

    private static WeatherData showCityWeather(String city) {
        return weatherDataMap.computeIfAbsent(city, key -> weatherMockService(city));
    }

    public static void updateWeatherData(String city, WeatherData weatherData) {
        weatherDataMap.put(city, weatherData);
    }

    private static void removeWeatherDataCity(String city) {
        weatherDataMap.remove(city);
    }

    private static void printAllCityInWeatherCache() {
        weatherDataMap.forEach((key, value) -> System.out.println(key));
    }

    private static WeatherData weatherMockService(String city) {
        return new WeatherData(city, 99, 99);
    }
}
