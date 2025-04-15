package school.faang.cachecache;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {

        return (System.currentTimeMillis() - data.timeStamp()) <= maxCacheAgeMillis;
    }
}
