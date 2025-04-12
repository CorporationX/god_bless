package school.faang.bjs2_69933;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return false;
    }
}
