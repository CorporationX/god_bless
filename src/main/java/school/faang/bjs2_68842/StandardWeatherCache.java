package school.faang.bjs2_68842;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherServiceImpl weatherService) {
        super(weatherService);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.timestamp() > maxCacheAgeMillis;
    }
}