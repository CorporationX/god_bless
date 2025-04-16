package school.faang.sprint_1.caching_caching;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache() {
        super(new WeatherService());
    }

    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - weatherData.timestamp() > maxCacheAgeMillis;
    }
}
