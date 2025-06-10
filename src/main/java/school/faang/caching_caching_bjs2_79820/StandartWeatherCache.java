package school.faang.caching_caching_bjs2_79820;

public class StandartWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        long dataAge = currentTime - data.getTimestamp();

        return dataAge > maxCacheAgeMillis;
    }
}