package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private final static Map<String, WeatherData> weather = new HashMap<>();

    public static void main(String[] args) {
        weather.put("Moscow", new WeatherData("Moscow", 23, 70));
        weather.put("London", new WeatherData("London", 18, 85));

        getWeather("Moscow");
        getWeather("Baku");  //not in cache
        updateCache("Moscow");  // update info exist cash
        getWeather("Moscow");
        removeCache("London");
        getAllCache();

    }

    public static void getWeather(String city) {
        if (!weather.containsKey(city)) {
            fillWeather(city);
        }
        System.out.println("Weather information in the city: " + city + " - Temperature: " +
                weather.get(city).getTemperature() + " Humidity: " + weather.get(city).getHumidity());
    }

    public static void fillWeather(String city) {
        Random value = new Random();
        weather.put(city, new WeatherData(city, value.nextInt(0, 30), value.nextInt(20, 100)));
    }

    public static void updateCache(String city) {
        fillWeather(city);
    }

    public static void removeCache(String city) {
        weather.remove(city);
    }

    public static void getAllCache() {
        System.out.println("\n" + "All information about weather:");
        for (Map.Entry entry : weather.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}