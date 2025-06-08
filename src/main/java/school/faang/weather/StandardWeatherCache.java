package school.faang.weather;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        var sinceLastMeasureMillis = System.currentTimeMillis() - data.timestamp();
        return sinceLastMeasureMillis > maxCacheAgeMillis;
    }
}
