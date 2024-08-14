package faang.school.godbless.caching;

public class Service {
    public static WeatherData getWeatherData(String city) {
        WeatherData weatherData = new WeatherData("Mock City", 36.6F, 81.5F);

        return weatherData;
    }
}
