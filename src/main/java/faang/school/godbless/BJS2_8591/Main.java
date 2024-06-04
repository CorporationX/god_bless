package faang.school.godbless.BJS2_8591;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
  static Map<String, WeatherData> weathers = new HashMap<>();
  static Random r = new Random();

  public static void main(String[] args) {
    weathers.put("city1", new WeatherData("city1", 10, 10));
    weathers.put("city2", new WeatherData("city2", 15, 8));
    weathers.put("city3", new WeatherData("city3", 17, 5));

    System.out.println(getWeatherByCity("city1"));
    System.out.println(getWeatherByCity("city4"));
    System.out.println(weathers);
    refreshWeather("city2");
    System.out.println(weathers);
    deleteWeather("city3");
    getAllWeathers();
  }

  public static WeatherData getWeatherByCity(String city) {
    if (weathers.containsKey(city)) {
      return weathers.get(city);
    } else {
      weathers.put(city, getWeather(city));
      return weathers.get(city);
    }
  }

  private static WeatherData getWeather(String city) {
    return new WeatherData(city, r.nextInt(0, 100), r.nextInt(0, 100));
  }

  public static void refreshWeather(String city) {
    weathers.put(city, new WeatherData(city, r.nextInt(0, 100), r.nextInt(0, 100)));
  }

  public static void deleteWeather(String city) {
    weathers.remove(city);
  }

  public static void getAllWeathers() {
    for (Map.Entry<String, WeatherData> entry : weathers.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
