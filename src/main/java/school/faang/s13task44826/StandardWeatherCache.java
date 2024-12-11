package school.faang.s13task44826;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider provider;

    @Override
   protected boolean isCacheExpired(WeatherData weatherData, long maxCacheAgeMillis) {
        if (!(weatherData == null)) {
            long currentTime = System.currentTimeMillis();
            return (currentTime - weatherData.getTimestamp()) > maxCacheAgeMillis;
        } else {
            log.warn("weather data cannot be null");
        }
        return false;
    }

    @Override
   protected void updateWeatherData(City city) {
        WeatherData updatedData = provider.fetchWeatherData(city);
        getWeatherDataCache().put(city.name(), updatedData);
    }
}
