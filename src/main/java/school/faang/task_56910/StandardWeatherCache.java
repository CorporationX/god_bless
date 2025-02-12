package school.faang.task_56910;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private WeatherProvider provider;

    public StandardWeatherCache(WeatherProvider provider) {
        this.provider = provider;
    }

    @Override
    protected WeatherProvider createWeatherProvider() {
        return provider;
    }
}
