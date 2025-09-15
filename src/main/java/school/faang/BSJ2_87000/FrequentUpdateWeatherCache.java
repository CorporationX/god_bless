package school.faang.BSJ2_87000;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return true;
    }
}
