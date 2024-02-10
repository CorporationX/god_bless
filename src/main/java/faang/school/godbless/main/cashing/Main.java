package faang.school.godbless.main.cashing;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherCash = new HashMap<>();
    public static void main(String... args) {
        weatherCash.put("Moscow", new WeatherData("Moscow", -20, 10));
        weatherCash.put("Saint-Petersburg", new WeatherData("Saint-Petersburg", -10, 90));
        weatherCash.put("Oslo", new WeatherData("Oslo", 15, 50));
        weatherCash.put("New York", new WeatherData("New York", 20, 40));
        printAllCities();
        deleteData("Moscow");
        printAllCities();
        WeatherData data = getWeather("Oslo");
        System.out.println(data.getCity() + " " + data.getTemperature() + " " + data.getHumidity());
        data = getWeather("Paris");
        System.out.println(data.getCity() + " " + data.getTemperature() + " " + data.getHumidity());
        updateData("Paris", new WeatherData("Paris", -15, 20));
        data = getWeather("Paris");
        System.out.println(data.getCity() + " " + data.getTemperature() + " " + data.getHumidity());
    }

    public static WeatherData getWeather(String city) {
        WeatherData data = weatherCash.get(city);
        if (data == null) {
            data = MockData.getData(city);
            weatherCash.put(city, data);
        }
        return data;
    }

    public static void updateData(String city, WeatherData data) {
        weatherCash.put(city, data);
    }

    public static void deleteData(String city) {
        weatherCash.remove(city);
    }

    public static void printAllCities() {
        for (var city : weatherCash.keySet()) {
            System.out.println(city);
        }
    }
}
