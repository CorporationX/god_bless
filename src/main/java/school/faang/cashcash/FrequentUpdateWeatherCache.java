package school.faang.cashcash;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate{

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
