package school.faang.task_44821;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    @Override
    protected boolean isCacheValid(City city) {
        return false;
    }

    @Override
    protected void updateWeatherData(City city) {
        WeatherData updatedWeatherData = weatherProvider.fetchWeatherData(city);
        weatherCache.put(city, updatedWeatherData);
    }
}
