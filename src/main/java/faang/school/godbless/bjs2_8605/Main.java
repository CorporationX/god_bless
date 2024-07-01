package faang.school.godbless.bjs2_8605;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

  private static final String WEATHER_IN_CITY = "Температура и влажность в городе ";
  private static final String SEPARATOR = " : ";
  private static final Map<String, WeatherData> weatherDataCache = new HashMap<>();

  public static void main(String[] args) {
    showInformation(getWeatherInformation("Екатеринбург"));
    showInformation(getWeatherInformation("Курган"));
    showInformation(getWeatherInformation("Тюмень"));

    showAllCityFromCache();

    showInformation(getWeatherInformation("Курган"));
    showInformation(getWeatherInformation("Тюмень"));

    updateWeatherInformationInCache("Курган", 35, 5);
    updateWeatherInformationInCache("Екатеринбург", 10, 1);

    showAllCityFromCache();

    deleteWeatherInformationFromCache("Екатеринбург");

    showAllCityFromCache();
  }

  private static WeatherData getWeatherInformation(String city) {
    if(weatherDataCache.containsKey(city)) {
      return weatherDataCache.get(city);
    }
    final var weatherData = getWeatherData(city);
    updateWeatherInformationInCache(city, weatherData.getTemperature(), weatherData.getHumidity());
    return weatherData;
  }

  private static void updateWeatherInformationInCache(String city, int temperature, int humidity) {
    weatherDataCache.put(city, new WeatherData(city, temperature, humidity));
  }

  private static void deleteWeatherInformationFromCache(String city) {
    weatherDataCache.remove(city);
  }

  private static void showAllCityFromCache() {
    weatherDataCache.forEach((key, value) -> System.out.println(WEATHER_IN_CITY + key +
        SEPARATOR + value.getTemperature() + SEPARATOR + value.getHumidity()));
  }

  private static void showInformation(WeatherData weatherData) {
    System.out.println(WEATHER_IN_CITY + weatherData.getCity() +
        SEPARATOR + weatherData.getTemperature() + SEPARATOR + weatherData.getHumidity());
  }

  private static WeatherData getWeatherData(String city) {
    return new WeatherData(city, new Random().nextInt(-50, 50), new Random().nextInt(0, 30));
  }

}
