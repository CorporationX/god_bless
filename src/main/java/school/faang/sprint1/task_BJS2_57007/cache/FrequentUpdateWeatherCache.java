package school.faang.sprint1.task_BJS2_57007.cache;

import school.faang.sprint1.task_BJS2_57007.data.WeatherData;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public WeatherData getWeatherData(String city, long plug) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Город не может быть пустым : " + city);
        }
        return updateWeatherData(city);
    }
}
