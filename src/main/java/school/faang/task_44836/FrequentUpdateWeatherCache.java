package school.faang.task_44836;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        System.out.println("Forced data update for the city: " + city);
        return forceUpdateWeather(city);
    }
}