package school.faang.godbless.bjs2_32574;

import java.util.HashMap;
import java.util.Map;

public class Main {

  private static final Map<String, WeatherData> cachedData = new HashMap<>();

  public static void main(String[] args) {
    System.out.println(getWeatherData("Moscow"));
    System.out.println(getWeatherData("Moscow"));
    removeFromCache("Moscow");
    System.out.println(getWeatherData("St Petersburg"));
    refreshData("St Petersburg");
    printCachedData();
  }

  private static WeatherData getWeatherData(String city) {
    if (cachedData.containsKey(city)) {
      return cachedData.get(city);
    }
    WeatherData data = MockWeatherService.getWeather(city);
    cachedData.put(city, data);
    return data;
  }

  private static void refreshData(String city) {
    cachedData.put(city, MockWeatherService.getWeather(city));
  }

  private static void removeFromCache(String city) {
    cachedData.remove(city);
  }

  private static void printCachedData() {
    System.out.println(cachedData);
  }
}
