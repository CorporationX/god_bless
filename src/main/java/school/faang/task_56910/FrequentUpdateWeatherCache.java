package school.faang.task_56910;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private WeatherProvider provider;

    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        this.provider = provider;
    }

    @Override
    protected WeatherProvider createWeatherProvider() {
        return provider;
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }
}
