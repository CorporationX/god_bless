package cachecache;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
