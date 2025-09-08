package school.faang.module1.weather;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return data == null || System.currentTimeMillis() - data.timestamp() >= maxCacheAgeMillis;
    }
}
