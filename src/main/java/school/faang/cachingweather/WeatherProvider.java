package school.faang.cachingweather;

public interface WeatherProvider {

    public abstract WeatherData fetchWeatherData(String city);
}
