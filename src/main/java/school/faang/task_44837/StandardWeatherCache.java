package school.faang.task_44837;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    protected WeatherData fetchWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
