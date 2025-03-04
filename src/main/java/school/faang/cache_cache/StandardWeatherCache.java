package school.faang.cache_cache;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @Override
    public WeatherData updateWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }

    @Override
    public boolean isCacheExpired(WeatherData cityWeatherData, long maxCacheAgeMillis) {
        return (System.currentTimeMillis() - cityWeatherData.getTimestamp()) >= maxCacheAgeMillis;
    }
}
