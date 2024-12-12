package school.faang.sprint1.bjs_44850;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final long maxCacheAgeMillis;
    private final WeatherProvider weatherProvider;

    @Override
    protected boolean isCacheValid(String city) {
        if (!getCache().containsKey(city)) {
            return false;
        }
        long timestamp = getCache().get(city).getTimestamp();
        long currentTime = System.currentTimeMillis();

        return currentTime - timestamp < maxCacheAgeMillis;
    }

    @Override
    protected void updateWeatherData(String city) {
        getCache().put(city, weatherProvider.fetchWeatherData(city));
    }
}
