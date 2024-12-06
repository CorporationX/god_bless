package school.faang.task_44824;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherService weatherService) {
        super(weatherService);
    }

    @Override
    protected boolean isActualData(WeatherData weatherData) {
        return false;
    }
}
