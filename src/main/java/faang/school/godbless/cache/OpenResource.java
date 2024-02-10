package faang.school.godbless.cache;

public class OpenResource {
    public static WeatherData searchForWeather(String city) {
        return new WeatherData(city, 30, 50);
    }
}
