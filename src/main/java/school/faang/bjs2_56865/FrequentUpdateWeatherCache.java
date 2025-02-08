package school.faang.bjs2_56865;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider provider;

    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        this.provider = provider;
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }

    @Override
    protected void updateWeatherData(String city) {
        WeatherData data = provider.fetchWeatherData(city);
        weatherCache.put(city, data);
    }
}
