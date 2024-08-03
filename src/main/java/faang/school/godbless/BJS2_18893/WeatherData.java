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
}
