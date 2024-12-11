package school.faang.task_44837;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    @Override
    protected boolean isCacheExpired(WeatherData wd, long maxCacheAgeMillis) {
        return true; //всегда обновляем данные
    }

    @Override
    protected WeatherData fetchWeatherData(String city) {
        return  weatherProvider.fetchWeatherData(city);
    }
}
