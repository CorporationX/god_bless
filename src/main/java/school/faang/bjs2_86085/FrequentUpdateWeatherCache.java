package school.faang.bjs2_86085;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - data.getTimestamp();
        return elapsedTime > maxCacheAgeMillis;
    }
}