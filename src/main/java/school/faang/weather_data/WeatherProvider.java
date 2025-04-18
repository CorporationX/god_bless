package school.faang.weather_data;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
