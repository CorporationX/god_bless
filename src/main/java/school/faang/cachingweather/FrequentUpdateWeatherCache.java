package school.faang.cachingweather;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache() {
        super();
    }

    @Override
    public boolean isCacheExpired(WeatherData data) {
        return true;
    }

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        return super.forceUpdateWeather(city);
    }
}
