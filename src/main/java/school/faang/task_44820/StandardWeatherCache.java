package school.faang.task_44820;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheValid(WeatherData weatherData, long maxCacheAgeMillis) {
        return (System.currentTimeMillis() - weatherData.getTimestamp()) <= maxCacheAgeMillis;
    }

    @Override
    public WeatherData updateWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
