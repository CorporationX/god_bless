package school.faang.weathercache;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
