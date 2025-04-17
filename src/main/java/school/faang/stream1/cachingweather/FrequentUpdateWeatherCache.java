package school.faang.stream1.cachingweather;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache() {
        super();
    }

    @Override
    public boolean isCacheExpired(WeatherData data) {
        return true;
    }

    @Override
    public WeatherData getWeatherData(String city) {
        return super.forceUpdateWeather(city);
    }
}
