package school.faang.bjs2_79901;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.timestamp() > maxCacheAgeMillis;
    }
}