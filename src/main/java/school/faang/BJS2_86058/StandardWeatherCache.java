package school.faang.BJS2_86058;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }
}
