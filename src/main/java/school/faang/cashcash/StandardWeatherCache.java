package school.faang.cashcash;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        long timeActual = currentTime - data.getTimestamp() ;
        return maxCacheAgeMillis <= timeActual;
    }
}