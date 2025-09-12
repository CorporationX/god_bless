package school.faang.BSJ2_87000;

public class StandardWeathCache extends WeatherCacheTemplate {
    @Override
    public boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return (System.currentTimeMillis() - weatherData.getTimestamp()) > maxCacheAgeMillis;
    }
}
