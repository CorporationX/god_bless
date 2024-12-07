package school.faang.task_44819;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return ( currentTime - weatherData.getTimestamp() > maxCacheAgeMillis );
    }
}
