package school.faang.task_44821;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;
    private final long maxCacheAgeMillis;

    public StandardWeatherCache(WeatherProvider weatherProvider, long maxCacheAgeMillis) {
        this.weatherProvider = weatherProvider;
        this.maxCacheAgeMillis = maxCacheAgeMillis;
    }

    @Override
    protected boolean isCacheValid(City city) {
        if (!weatherCache.containsKey(city)) {
            return false;
        }
        return System.currentTimeMillis() - weatherCache.get(city).getTimestamp() < maxCacheAgeMillis;
    }

    @Override
    protected void updateWeatherData(City city) {
        WeatherData updatedWeatherData = weatherProvider.fetchWeatherData(city);
        weatherCache.put(city, updatedWeatherData);
    }
}