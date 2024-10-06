package school.faang.weather;

public class WeatherService {
    public static WeatherData provideData(String city) {
        double temperature = Math.random() * 30;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }
}
