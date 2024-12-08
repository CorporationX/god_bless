package school.faang.task_44819;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherService weatherService) {
        super(weatherService);
    }

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - weatherData.getTimestamp() > maxCacheAgeMillis);
    }
}
