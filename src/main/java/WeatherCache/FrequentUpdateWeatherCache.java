package WeatherCache;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        return updateWeatherData(city);
    }
}
