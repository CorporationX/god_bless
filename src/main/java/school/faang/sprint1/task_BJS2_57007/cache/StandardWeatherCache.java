package school.faang.sprint1.task_BJS2_57007.cache;

import school.faang.sprint1.task_BJS2_57007.data.WeatherData;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = this.getCitiesWeather().get(city);

        if (data == null || this.isCacheExpired(data, maxCacheAgeMillis)) {
            data = updateWeatherData(city);
        }
        return data;
    }
}
