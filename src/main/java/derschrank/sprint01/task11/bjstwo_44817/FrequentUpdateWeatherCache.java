package derschrank.sprint01.task11.bjstwo_44817;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    protected boolean isCacheNullOrExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }
}
