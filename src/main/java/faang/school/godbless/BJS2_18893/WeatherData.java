package faang.school.godbless.BJS2_18893;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@ToString
public class WeatherData {

    private String city;
    private double temperature;
    private int humidity;

    public static WeatherData getWeatherData(Map<String, WeatherData> weatherCity, String city) {
        if (!weatherCity.containsKey(city)) {
            WeatherData weatherData = WeatherDataService.getRandomWeatherData(city);
            weatherCity.put(city, weatherData);
        }
        return weatherCity.get(city);
    }

    public static void updateWeatherData(Map<String, WeatherData> weatherCity, String city, WeatherData weatherData) {
        weatherCity.put(city, weatherData);
    }

    public static void deleteWeatherData(Map<String, WeatherData> weatherCity, String city) {
        weatherCity.remove(city);
    }

    public static void printAllCities(Map<String, WeatherData> weatherCity) {
        weatherCity.keySet().forEach(System.out::println);
    }
}
