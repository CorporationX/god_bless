package school.faang.module1.bjs2_79786;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider provider) {
        super(provider);
    }

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return currentTime - data.getTimestamp() > maxCacheAgeMillis;
    }
}