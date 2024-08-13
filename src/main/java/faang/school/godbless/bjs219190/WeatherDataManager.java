package faang.school.godbless.bjs219190;

import java.util.Map;

public class WeatherDataManager {
    public static WeatherData getWeatherData(Map<String, WeatherData> weatherData, String city) {
        if (!weatherData.containsKey(city)) {
            WeatherData newData = ExternalService.getWeatherData(city);
            weatherData.put(city, newData);
        }
        return weatherData.get(city);
    }

    public static void updateWeatherData(Map<String, WeatherData> weatherData, String city) {
        WeatherData newData = ExternalService.getWeatherData(city);
        weatherData.put(city, newData);
    }

    public static void deleteWeatherData(Map<String, WeatherData> weatherData, String city) {
        weatherData.remove(city);
    }

    public static void printWeatherData(Map<String, WeatherData> weatherData) {
        weatherData.forEach((city, data) -> System.out.printf(
                "%s: temperature: %.1f, humidity: %.0f%n", city, data.getTemperature(), data.getHumidity()
        ));
    }
}
