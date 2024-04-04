package faang.school.godbless.caching;

public class WeatherService {
    private final static WeatherData MOCK_DATA = new WeatherData("", 0, 0);

    public static WeatherData info() {
        return MOCK_DATA;
    }
}
