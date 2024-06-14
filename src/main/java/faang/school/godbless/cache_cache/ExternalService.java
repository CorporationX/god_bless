package faang.school.godbless.cache_cache;

public class ExternalService {
    public static WeatherData getDataAboutWeather(String cityName) {
        return new WeatherData(cityName, 20, 68);
    }
}
