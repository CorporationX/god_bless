package school.faang.BJS232615;

public class WeatherService {
    public static WeatherData getWeatherData(String nameOfCity) {
        return new WeatherData(nameOfCity, Math.round(Math.random() * 40), Math.round(Math.random() * 30));
    }
}
