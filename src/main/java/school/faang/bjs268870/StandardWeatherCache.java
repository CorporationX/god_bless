package school.faang.bjs268870;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return currentTime - data.timestamp() > maxCacheAgeMillis;
    }
}
