package school.faang.hash_hash;

public class StandardWeatherCache extends WeatherCacheTemplate{

    public StandardWeatherCache() {
        super(new WeatherService());
    }

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimestamp()) > maxCacheAgeMillis;
    }
}
