package school.faang.task_44830.styles;

import school.faang.task_44830.WeatherCacheTemplate;
import school.faang.task_44830.WeatherData;
import school.faang.task_44830.WeatherProvider;

public class FrequentWeatherCache extends WeatherCacheTemplate {
    private WeatherProvider provider;

    public FrequentWeatherCache(WeatherProvider provider) {
        this.provider = provider;
    }

    @Override
    protected WeatherData fetchFreshData(String city) {
        return provider.fetchWeatherData(city);
    }

    @Override
    protected boolean isCacheValid(WeatherData data, long maxCacheAge) {
        return false;
    }
}