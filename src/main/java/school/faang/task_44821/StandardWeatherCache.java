package school.faang.task_44821;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;
    private final long maxCacheAgeMillis;

    @Override
    protected boolean isCacheValid(City city) {
        if (!getWeatherCache().containsKey(city)) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        long weatherDataTime = getWeatherCache().get(city).getTimestamp();

        return currentTime - weatherDataTime < maxCacheAgeMillis;
    }

    @Override
    protected void updateWeatherData(City city) {
        WeatherData updatedWeatherData = weatherProvider.fetchWeatherData(city);
        getWeatherCache().put(city, updatedWeatherData);
    }
}