package faang.school.godbless.BJS2_5091;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;


    public static WeatherData getWeatherByCity(HashMap<String, WeatherData> weatherData, String city) {
        if (weatherData.containsKey(city)) {
            return weatherData.get(city);
        } else {
            WeatherData weatherDataFromService = getWeatherFromService(city);
            WeatherData.updateWeather(weatherData, weatherDataFromService);
            return weatherDataFromService;
        }
    }

    private static WeatherData getWeatherFromService(String city) {
        return new WeatherData(city, (int) (Math.random() * 30), (int) (Math.random() * 100));
    }

    public static void updateWeather(HashMap<String, WeatherData> weatherData, WeatherData data) {
        weatherData.put(data.getCity(), data);
    }

    public static void removeWeather(HashMap<String, WeatherData> weatherData, String city) {
        weatherData.remove(city);
    }

    public static void printAllWeatherCity(HashMap<String, WeatherData> weatherData) {
        for (Map.Entry<String, WeatherData> entry : weatherData.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println(entry.getKey() + ": " + "temperature = " + entry.getValue().getTemperature() +
                        ", humidity = " + entry.getValue().getHumidity());
            }
        }
    }
}
