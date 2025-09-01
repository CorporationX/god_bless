package school.faang.weather;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
