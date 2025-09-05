package school.faang.weather;

public interface WeatherProvider {

    WeatherData fetchWeatherData(String city);
}
