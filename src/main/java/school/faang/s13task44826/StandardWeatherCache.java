package school.faang.s13task44826;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider provider;

    @Override
   protected boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        return weatherData == null || System.currentTimeMillis() - weatherData.getTimestamp() > maxCacheAgeMillis;
    }

    @Override
   protected WeatherData updateWeatherData(City city) {
        WeatherData updatedData = provider.fetchWeatherData(city);
        getWeatherDataCache().put(city.name(), updatedData);
        return updatedData;
    }
}