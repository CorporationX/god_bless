package school.faang.bjs244816;

public class WeatherProvider {
    public static WeatherData fetchWeatherData(String city) {
        return new WeatherData("London", 20, 80, 121212);
    }
}
