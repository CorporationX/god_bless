package faang.school.godbless.cacheCache;

public class MockWeather {
    public static WeatherData giveInfoAboutWeatherOuter(String city) {
        return new WeatherData(city, 0, 0);
    }
}