package school.faang.task_44908;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;
    private final int cacheExpiryTime;

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider, int cacheExpiryTime) {
        this.weatherProvider = weatherProvider;
        this.cacheExpiryTime = cacheExpiryTime;
    }

    @Override
    protected WeatherData fetchWeatherDataFromProvider(String city) {
        return weatherProvider.fetchWeatherData(city);
    }

    @Override
    protected boolean isDataFresh(WeatherData weatherData) {
        final long currentTimestamp = System.currentTimeMillis();
        final long cachedTimestamp = weatherData.getTimestamp();

        return currentTimestamp - cachedTimestamp < cacheExpiryTime;
    }
}
