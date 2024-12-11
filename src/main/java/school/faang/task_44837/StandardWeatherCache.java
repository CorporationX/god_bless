package school.faang.task_44837;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider weatherProvider;

    @Override
    protected WeatherData fetchWeatherData(String city) {
        return weatherProvider.fetchWeatherData(city);
    }
}
