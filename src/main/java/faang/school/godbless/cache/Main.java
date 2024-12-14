

import faang.school.godbless.cache.WeatherData;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherData = new HashMap<>();

    public static void main(String[] args) {
        weatherData.put("London", new WeatherData("London", 15, 75));
        weatherData.put("Berlin", new WeatherData("Berlin", 10, 77));
        addDataToCache("New york");
        getData();
        updateCacheData("London", 25, 80);
        deleteData("Berlin");
        System.out.println("after update");
        getData();
    }

    private static void updateCacheData(String city, Integer temperature, Integer humidity) {
        WeatherData data = new WeatherData(city, temperature, humidity);
        weatherData.computeIfPresent(city, (k, v) -> data);
    }

    private static void deleteData(String city) {
        weatherData.computeIfPresent(city, (k, v) -> null);
    }

    private static void addDataToCache(String city) {
        weatherData.computeIfAbsent(city, data -> {
            System.out.println("request for new data");
            return new WeatherData(city, 15, 75);
        });
    }
    private static void getData() {
        for (Map.Entry<String, WeatherData> item : weatherData.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
