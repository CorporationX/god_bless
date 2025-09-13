package school.faang.bjs2_86067;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    protected boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return data.getTimestamp() > maxCacheAgeMillis;
    }
}