package school.faang.task_44908;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;
    private static final int CACHE_EXPIRY_TIME = 2000;

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @Override
    protected WeatherData fetchWeatherDataFromProvider(String city) {
        return weatherProvider.fetchWeatherData(city);
    }

    @Override
    protected boolean isDataFresh(WeatherData weatherData) {
        final long currentTimestamp = System.currentTimeMillis();
        final long cachedTimestamp = weatherData.getTimestamp();

        return currentTimestamp - cachedTimestamp < CACHE_EXPIRY_TIME;
    }
}
