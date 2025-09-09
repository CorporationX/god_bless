package school.faang.cash.cash;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }

    @Override
    WeatherData forceUpdateWeather(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
