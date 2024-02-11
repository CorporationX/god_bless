package src.main.java.faang.school.godbless;

public class MeteoService {
    public static WeatherData getWeather(String city) {
        int temperature = (int) (Math.random() * 22);
        int humidity = (int) (Math.random() * 22);
        return new WeatherData(city, temperature, humidity);
    }
}
