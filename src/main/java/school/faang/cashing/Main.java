package school.faang.cashing;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();
    private static final MockClass mock = new MockClass();

    public static void main(String[] args) {
        getInfoForCity("New York");
        getInfoForCity("Moscow");
        getInfoForCity("Saint Petersburg");
        printInfo();
        updateInfo("New York");
        printInfo();
        removeInfo("Moscow");
        printAllCities();
    }

    private static WeatherData getInfoForCity(String city) {
        WeatherData info = weatherCache.get(city);
        if (info == null) {
            WeatherData data = mock.getInfo(city);
            weatherCache.put(city, data);
        }
        return info;
    }

    private static void updateInfo(String city) {
        WeatherData updatedData = mock.getInfo(city);
        weatherCache.put(city, updatedData);
    }

    private static void removeInfo(String city) {
        weatherCache.remove(city);
    }

    private static void printAllCities() {
        System.out.println(weatherCache.keySet());
    }

    private static void printInfo() {
        for (var entry : weatherCache.entrySet()) {
            System.out.println("City: " + entry.getKey());
            System.out.println("Temperature: " + entry.getValue().getTemperature());
            System.out.println("Humidity: " + entry.getValue().getHumidity());
            System.out.println("--------------");
        }
    }
}
