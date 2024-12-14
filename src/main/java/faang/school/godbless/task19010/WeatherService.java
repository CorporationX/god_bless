package faang.school.godbless.task19010;


public class WeatherService {

    public static WeatherData getWeather(String city){
        return new WeatherData(city, 22, 70);
    }
}
