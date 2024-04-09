package faang.school.godbless.weather_forecast;

public class WeatherService {
    public WeatherData getWeatherData(String city){
        return new WeatherData(city, 27, 64);
    }
}
