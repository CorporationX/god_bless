package school.faang.sprint1.bjs_44850;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    @Override
    protected boolean isCacheValid(String city) {
        return false;
    }

    @Override
    protected void updateWeatherData(String city) {
        getCache().put(city, weatherProvider.fetchWeatherData(city));
    }
}
