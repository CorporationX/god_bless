package school.faang.task_44866;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    protected boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - weatherData.getTimestamp() > maxCacheAgeMillis;
    }
}
