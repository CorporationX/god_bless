package dima.evseenko.weather;

public interface WeatherRepository {
    WeatherData getWeather(String city);
}
