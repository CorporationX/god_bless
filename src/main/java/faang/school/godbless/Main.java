package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
  private static Map<String, WeatherData> weather = new HashMap<>();

  public static void main(String[] args) {
    weather.put("city", new WeatherData("city", 11.0, 11.0));
    weather.put("city1", new WeatherData("city1", 12.0, 12.0));
    weather.put("city2", new WeatherData("city2", 13.0, 13.0));

    getWeatherDataByCity("city1");
    getWeatherDataByCity("city10");
    updateWeatherData("city2", new WeatherData("city3", 14.0, 14.0));
    deleteWeatherData("city10");
    getAllWheaterData().forEach((k, v) -> System.out.println(k + " - " + v));
  }
  public static WeatherData getWeatherDataByCity(String city) {
    if (!weather.containsKey(city)) {
      weather.put(city, weatherService(city));
    }
    return weather.get(city);
  }
  public static void updateWeatherData(String city, WeatherData weatherData) {
    weather.put(weatherData.getCity(), weatherData);
  }
  public static void deleteWeatherData(String city) {
    weather.remove(city);
  }
  public static Map<String, WeatherData> getAllWheaterData() {
    return weather;
  }
  public static WeatherData weatherService(String city) {
    return new WeatherData(city, new Random().nextDouble(), new Random().nextDouble());
  }
}
