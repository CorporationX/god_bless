package faang.school.godbless.cashCash;

public class WeatherSource {
    public static WeatherData getWeather(String city) {
        return new WeatherData(city, 666.666, 101);
    }
}
