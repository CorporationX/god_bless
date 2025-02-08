package school.faang.bjs2_56865;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider provider;

    public StandardWeatherCache(WeatherProvider provider) {
        this.provider = provider;
    }

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long differenceMillis = System.currentTimeMillis() - data.getTimestamp();
        return differenceMillis > maxCacheAgeMillis;
    }

    @Override
    protected void updateWeatherData(String city) {
        WeatherData data = provider.fetchWeatherData(city);
        weatherCache.put(city, data);
    }
}
