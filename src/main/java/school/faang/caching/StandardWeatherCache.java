package school.faang.caching;

public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache() {
        super(new WeatherService());
    }

    @Override
    protected WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        return super.getWeatherData(city, maxCacheAgeMillis);
    }
}
