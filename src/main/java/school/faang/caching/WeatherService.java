package school.faang.caching;

public class WeatherService {
    public WeatherData getWeatherData(String cityName) {
        return new WeatherData(cityName, 25, 80);
    }
}
