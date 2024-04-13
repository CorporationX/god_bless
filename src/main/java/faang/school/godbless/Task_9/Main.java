package faang.school.godbless.Task_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, WeatherData> weather = new HashMap<>();
        weather.put("Moscow", new WeatherData("Moscow", -20, 50));
        weather.put("London", new WeatherData("London", 20, 30));
        weather.put("New-York", new WeatherData("New-York", 10, 60));

        weatherInfo(weather, "Paris");

        updateWeather(weather, "Moscow", 15, 30);

        removeInfo(weather, "New-York");

        allCities(weather);

    }

    static void weatherInfo(Map<String, WeatherData> weather, String cityName) {
        if (cityName != null) {
            if (weather.containsKey(cityName)) {
                int humidity = weather.get(cityName).getHumidity();
                int temperature = weather.get(cityName).getTemperature();
                System.out.println("Humidity = " + humidity + " and " + "temperature = " + temperature);
            } else {
                weather.put(cityName, new WeatherInfo().wInfo(cityName));
                System.out.println(weather);
            }
        }
    }

    static void updateWeather(Map<String, WeatherData> weather, String cityName, int temperature, int humidity) {
        if (weather.containsKey(cityName)) {
            WeatherData weatherData = new WeatherData(cityName, temperature, humidity);
            weather.putIfAbsent(cityName, weatherData);
        }
        System.out.println(weather);
    }

    static void removeInfo(Map<String, WeatherData> weather, String cityName) {
        if (cityName != null && weather != null) {
            weather.remove(cityName);
        }
        System.out.println(weather);
    }

    static void allCities(Map<String, WeatherData> weather) {
        List<WeatherData> cities = new ArrayList<>();
        for (Map.Entry<String, WeatherData> entry : weather.entrySet()) {
            WeatherData value = entry.getValue();
            cities.add(value);
        }
        System.out.println(cities);
    }
}
