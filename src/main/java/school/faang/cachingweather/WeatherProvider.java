package school.faang.cachingweather;

public interface WeatherProvider {

    WeatherData fetchWeatherData(String city);
}
