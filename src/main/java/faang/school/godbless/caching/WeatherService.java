package faang.school.godbless.caching;

public class WeatherService {
    private final static WeatherData mockData = new WeatherData("", 0, 0);

    public static WeatherData info() {
        return mockData;
    }
}
