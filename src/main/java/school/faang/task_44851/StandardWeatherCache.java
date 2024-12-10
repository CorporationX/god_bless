package school.faang.task_44851;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider provider;

    public StandardWeatherCache(WeatherProvider provider) {
        this.provider = provider;
    }

    @Override
    protected WeatherData fetchFreshData(String city) {
        // Запрос свежих данных через WeatherProvider
        return provider.fetchWeatherData(city);
    }
}

