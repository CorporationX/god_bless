package school.faang.task_44819;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return true;
    }
}
