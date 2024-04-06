package faang.school.godbless.cachecache;

public class MockWeatherService {
    public static WeatherData getWeatherData() {
        return new WeatherData("City", 22, 80);
    }
}
