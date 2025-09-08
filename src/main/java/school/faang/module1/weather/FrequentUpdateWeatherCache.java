package school.faang.module1.weather;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
