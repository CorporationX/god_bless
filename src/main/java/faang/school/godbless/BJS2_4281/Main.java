package faang.school.godbless.BJS2_4281;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, WeatherData> weathers = new HashMap<>();
    private static WeatherDataService weatherService = new WeatherDataService();

    public static void main(String[] args) {
        addWeather("Paris", new WeatherData("Paris", 23, 56));
        addWeather("Madrid", new WeatherData("Madrid", 20, 43));
        addWeather("Berlin", new WeatherData("Berlin", 21, 50));
        addWeather("Roma", new WeatherData("Roma", 23, 46));

        printInfo("Paris");
        printInfo("Bayern");

        printAll();

        updateWeather("Paris", new WeatherData("Paris", 29, 47));

        removeWeather("Madrid");

        printAll();
    }

    private static void addWeather(String cityName, WeatherData weatherData) {
        weathers.putIfAbsent(cityName, weatherData);
    }

    public static WeatherData printInfo(String city) {
        return weathers.computeIfAbsent(city, k -> weatherService.weatherData(city));
    }

    private static void updateWeather(String cityName, WeatherData data) {
        weathers.replace(cityName, data);
    }

    private static void removeWeather(String cityName) {
        weathers.remove(cityName);
    }

    private static void printAll() {
        for (var entry : weathers.entrySet()) {
            System.out.println("City: " + entry.getKey());
            System.out.println("Weather: " + entry.getValue());
        }
    }
}
