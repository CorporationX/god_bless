package school.faang.cashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weather = new HashMap<>();
    private static final MockClass mock = new MockClass();

    public static void main(String[] args) {
        WeatherData moscowWeather = new WeatherData("Moscow", 20.5, 40.2);
        WeatherData klinWeather = new WeatherData("Klin", 19.5, 44.5);
        WeatherData spbWeather = new WeatherData("Saint Petersburg", 16.8, 48.3);
        WeatherData nyWeather = new WeatherData("New York", 24.6, 37.6);

        add(moscowWeather);
        add(klinWeather);
        add(spbWeather);
        infoForCity("New York");
        printInfo();
        updateInfo(nyWeather);
        printInfo();
        removeInfo("Klin");
        printAllCities();
    }

    private static void add(WeatherData data) {
        weather.put(data.getCity(), data);
    }

    private static WeatherData infoForCity(String city) {
        WeatherData info = weather.get(city);
        if (info == null) {
            WeatherData data = mock.getInfo(city);
            weather.put(city, data);
        }
        return info;
    }

    private static void updateInfo(WeatherData data) {
        String city = data.getCity();
        weather.put(city, data);
    }

    private static void removeInfo(String city) {
        weather.remove(city);
    }

    private static void printAllCities() {
        List<String> cityList = new ArrayList<>();
        for (var entry : weather.entrySet()) {
            cityList.add(entry.getKey());
        }
        System.out.println(cityList);
    }

    private static void printInfo() {
        System.out.println(weather);
    }
}
