package school.faang.weather_data;

public class StandardWeatherCache extends WeatherCacheTemplate {
    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return (System.currentTimeMillis() - data.getTimestamp()) > maxCacheAgeMillis;
    }
}
