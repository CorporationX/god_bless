package school.faang.task_44821;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;
    private final long maxCacheAgeMillis;

    @Override
    protected boolean isCacheValid(City city) {
        if (!weatherCache.containsKey(city)) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        long weatherDataTime = weatherCache.get(city).getTimestamp();

        return currentTime - weatherDataTime < maxCacheAgeMillis;
    }

    @Override
    protected void updateWeatherData(City city) {
        WeatherData updatedWeatherData = weatherProvider.fetchWeatherData(city);
        weatherCache.put(city, updatedWeatherData);
    }
}