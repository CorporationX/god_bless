package school.faang.bsj2_32566_Cache;

public class WeatherWebMock {
    public static WeatherData provideData(String city) {
        return new WeatherData(city, 35.5, 70);
    }
}
