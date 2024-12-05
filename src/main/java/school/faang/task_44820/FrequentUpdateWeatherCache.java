package school.faang.task_44820;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {


    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheValid(WeatherData weatherData, long maxCacheAgeMillis) {
        return false;
    }

    @Override
    public WeatherData updateWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
