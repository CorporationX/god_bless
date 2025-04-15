package cachecache;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        if (data == null) {
            return true;
        }
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }
}
