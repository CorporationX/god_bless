package school.faang.task_44872;

public class StandartWeatherCache extends WeatherCacheTemplate {
    private long maxCacheAgeMillis;

    public StandartWeatherCache(WeatherProvider provider, long maxCacheAgeMillis) {
        this.maxCacheAgeMillis = maxCacheAgeMillis;
        this.provider = provider;
    }

    private WeatherProvider provider;

    @Override
    protected WeatherData getWeatherDataFromProvider(String city) {
        return provider.fetchWeatherData(city);
    }

    @Override
    protected long getMaxCacheAgeMillis() {
        return maxCacheAgeMillis;
    }
}
