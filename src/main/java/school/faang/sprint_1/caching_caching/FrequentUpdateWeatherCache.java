package school.faang.sprint_1.caching_caching;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache() {
        super(new WeatherService());
    }

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return true;
    }
}