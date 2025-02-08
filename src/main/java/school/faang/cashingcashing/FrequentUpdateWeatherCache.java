package school.faang.cashingcashing;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        updateWeatherData(city);
        return getWeathersDataCache().get(city);
    }

    public void clearExpiredCache() {
        getWeathersDataCache().clear();
    }
}
