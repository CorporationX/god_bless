package derschrank.sprint01.task11.bjstwo_44817;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    protected boolean isCacheNullOrExpired(WeatherData data, long maxCacheAgeMillis) {
        return data == null || System.currentTimeMillis() - data.timestamp() > maxCacheAgeMillis;
    }

}
