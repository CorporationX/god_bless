package school.faang.task_44821;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @Override
    protected boolean isCacheValid(City city) {
        return true;
    }

    @Override
    protected void updateWeatherData(City city) {
        WeatherData updatedWeatherData = weatherProvider.fetchWeatherData(city);
        weatherCache.put(city, updatedWeatherData);
    }
}
