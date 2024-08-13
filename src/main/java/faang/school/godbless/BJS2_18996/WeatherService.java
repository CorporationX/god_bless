package faang.school.godbless.BJS2_18996;

public class WeatherService {
    public static WeatherData getCurrentWeatherData(String city) {
        return new WeatherData(city, 21, 45);
    }
}
