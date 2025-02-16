package school.faang.bjs2_56915;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        return weatherProvider.fetchWeatherData(city);
    }
}
