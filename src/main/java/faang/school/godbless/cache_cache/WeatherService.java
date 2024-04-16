package faang.school.godbless.cache_cache;

public class WeatherService {
    public static WeatherData getWeather(String city){
        return new WeatherData(city, 15, 60);
    }
}
