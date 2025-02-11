package school.faang.bjs2_56865;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
