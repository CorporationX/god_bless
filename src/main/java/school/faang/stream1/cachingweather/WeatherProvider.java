package school.faang.stream1.cachingweather;

public interface WeatherProvider {

    WeatherData fetchWeatherData(String city);
}
