package faang.school.godbless.cache;

public class WeatherServer {
    static WeatherData weatherData = new WeatherData("Moscow",20,65);

    static public WeatherData getWeatherData(String name) {
        return weatherData;
    }
}
