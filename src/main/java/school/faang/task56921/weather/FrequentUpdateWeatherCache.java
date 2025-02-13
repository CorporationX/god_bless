package school.faang.task56921.weather;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        updateWeatherData(city);
        return getCityInfo().get(city);
    }
}
