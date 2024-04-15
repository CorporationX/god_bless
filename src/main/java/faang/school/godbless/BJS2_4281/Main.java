package faang.school.godbless.BJS2_4281;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, WeatherData> WEATHERS = new HashMap<>();
    private static final WeatherDataService WEATHER_DATA_SERVICE = new WeatherDataService();

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
        WEATHERS.putIfAbsent(cityName, weatherData);
    }

    public static WeatherData printInfo(String city) {
        return WEATHERS.computeIfAbsent(city, k -> WEATHER_DATA_SERVICE.weatherData(city));
    }

    private static void updateWeather(String cityName, WeatherData data) {
        WEATHERS.replace(cityName, data);
    }

    private static void removeWeather(String cityName) {
        WEATHERS.remove(cityName);
    }

    private static void printAll() {
        for (var entry : WEATHERS.entrySet()) {
            System.out.println("City: " + entry.getKey());
            System.out.println("Weather: " + entry.getValue());
        }
    }
}
