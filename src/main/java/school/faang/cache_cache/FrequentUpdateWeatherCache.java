package school.faang.cache_cache;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @Override
    public WeatherData updateWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return true;
    }
}
