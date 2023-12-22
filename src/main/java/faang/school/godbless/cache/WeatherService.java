package faang.school.godbless.cache;

public class WeatherService {
    public static WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, 15, 70);
    }
}
