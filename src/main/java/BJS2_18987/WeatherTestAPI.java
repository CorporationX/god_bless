package BJS2_18987;

public class WeatherTestAPI {
    public static WeatherData getWeather(String city) {
        return new WeatherData(city, Math.round(Math.random() * 40), Math.round(Math.random() * 99));
    }
}
