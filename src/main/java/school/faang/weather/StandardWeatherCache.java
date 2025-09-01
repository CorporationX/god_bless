package school.faang.weather;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return data == null || System.currentTimeMillis() - data.getTimestamp() >= maxCacheAgeMillis;
    }
}
