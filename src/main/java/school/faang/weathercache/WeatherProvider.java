package school.faang.weathercache;

public interface WeatherProvider {
    public WeatherData fetchWeatherData(String city);
}
