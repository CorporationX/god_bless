package school.faang.cashing;

public class MockClass {
    public WeatherData getInfo(String city) {
        return new WeatherData(city, 0, 0);
    }
}
