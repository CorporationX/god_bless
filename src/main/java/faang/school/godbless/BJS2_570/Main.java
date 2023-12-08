package faang.school.godbless.BJS2_570;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public static void main(String[] args) {
        weatherDataMap.put("New York", new WeatherData("New York", 20.0, 65.0));
        weatherDataMap.put("London", new WeatherData("London", 18.5, 70.0));
        weatherDataMap.put("Tokyo", new WeatherData("Tokyo", 28.5, 80.0));

        infoAllCitiesData();

        updateWeatherData("New York", new WeatherData("New York", 22.0, 60.0));

        System.out.println("After Update:");
        infoAllCitiesData();

        removeWeatherData("London");

        System.out.println("After Removal:");
        infoAllCitiesData();
    }

    public static String getWeatherData(String city) {
        return Optional.of(weatherDataMap.computeIfAbsent(city, key -> WeatherService.fetchWeatherData(key)))
                .map(data -> String.format("city: %s, temperature: %.2f, humidity: %.2f", data.getCity(), data.getTemperature(), data.getHumidity()))
                .orElse("Data not found");
    }

    public static void removeWeatherData(String city) {
        weatherDataMap.remove(city);
    }

    public static WeatherData updateWeatherData(String city, WeatherData newData) {
        return weatherDataMap.put(city, newData);
    }

    public static void infoAllCitiesData() {
        weatherDataMap.keySet().forEach(city -> System.out.println(getWeatherData(city)));
    }
}

class WeatherService {
    public static WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, 15.5, 57.0);
    }
}
