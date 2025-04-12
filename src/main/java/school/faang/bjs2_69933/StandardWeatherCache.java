package school.faang.bjs2_69933;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        if (System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis) {
            return true;
        }
        return false;
    }
}
