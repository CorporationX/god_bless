package WeatherCache;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        return super.getWeatherData(city, maxCacheAgeMillis);
    }
}