package WeatherCache;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
