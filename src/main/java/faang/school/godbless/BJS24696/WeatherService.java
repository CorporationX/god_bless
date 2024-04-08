package faang.school.godbless.BJS24696;

public class WeatherService {
    public static WeatherData getWeatherData(String city) {
        return city.equals("Москва") ? new WeatherData(city, 0, 0) :
                new WeatherData(city, -100, 70);
    }
}
