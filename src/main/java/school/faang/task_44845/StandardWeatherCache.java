package school.faang.task_44845;

import school.faang.task_44845.entity.WeatherData;

public class StandardWeatherCache extends WeatherCacheTemplate {
    WeatherProvider weatherProvider;

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @Override
    protected boolean isCacheActual(WeatherData cachedData, long maxCacheAgeMillis) {
        long now = System.currentTimeMillis();
        return (now - cachedData.getTimestamp()) <= maxCacheAgeMillis;
    }

    @Override
    protected WeatherData fetchNewData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
