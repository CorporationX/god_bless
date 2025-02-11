package school.faang.BJS2_56884;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
