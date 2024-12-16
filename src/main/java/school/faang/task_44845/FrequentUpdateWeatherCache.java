package school.faang.task_44845;

import school.faang.task_44845.entity.WeatherData;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    WeatherProvider weatherProvider;

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @Override
    protected boolean isCacheActual(WeatherData cachedData, long maxCacheAgeMillis) {
        return false;
    }

    @Override
    protected WeatherData fetchNewData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
