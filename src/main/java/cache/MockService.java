package cache;

public class MockService {
    public static WeatherData getWeather(String city) {
        return new WeatherData(city, (int) (Math.random()*100), (int) (Math.random()*100));
    }
}
