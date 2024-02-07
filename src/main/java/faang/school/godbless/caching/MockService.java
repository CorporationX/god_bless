package faang.school.godbless.caching;

public class MockService {

    public static WeatherData pullWeatherData() {
        return new WeatherData("Moscow", 21, 5);
    }
}
