package school.faang.task_44824;

public class StandartWeatherCache extends WeatherCacheTemplate {
    private static final long MAX_CACHE_AGE_MILLIS = 60000;

    public StandartWeatherCache(WeatherService weatherService) {
        super(weatherService);
    }

    @Override
    protected boolean isActualData(WeatherData weatherData) {
        return weatherData.timestamp() - System.currentTimeMillis() <= MAX_CACHE_AGE_MILLIS;
    }
}