package school.faang.s13task44826;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider provider;

    @Override
    protected boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return false;
    }

    @Override
    protected void updateWeatherData(City city) {
        WeatherData updatedData = provider.fetchWeatherData(city);
        getWeatherDataCache().put(city.name(), updatedData);
    }
}
