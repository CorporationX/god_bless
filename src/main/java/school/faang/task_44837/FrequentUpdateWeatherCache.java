package school.faang.task_44837;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData wd, long maxCacheAgeMillis) {
        return true; // Всегда обновляем данные
    }

    @Override
    protected WeatherData fetchWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
