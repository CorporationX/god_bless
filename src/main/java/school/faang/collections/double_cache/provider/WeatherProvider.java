package school.faang.collections.double_cache.provider;

public interface WeatherProvider {

    WeatherData fetchWeatherData(String city);
}