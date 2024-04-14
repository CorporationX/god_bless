package faang.school.godbless.cacheCache;

public class MockWeather {
    public WeatherData giveInfoAboutWeatherOuter(String city) {
        return new WeatherData(city, 0, 0);
    }
}