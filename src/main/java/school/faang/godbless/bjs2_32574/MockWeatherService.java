package school.faang.godbless.bjs2_32574;

public class MockWeatherService {

  public static WeatherData getWeather(String city) {
    System.out.println("Getting weather data from somewhere...");
    return new WeatherData(city, 10, 10);
  }
}
