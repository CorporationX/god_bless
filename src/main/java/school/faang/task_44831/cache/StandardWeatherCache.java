package school.faang.task_44831.cache;

import org.apache.commons.lang3.StringUtils;
import school.faang.task_44831.entity.WeatherData;
import school.faang.task_44831.provider.WeatherService;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (StringUtils.isBlank(city)) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }

        weatherProvider = new WeatherService();
        WeatherData weatherData = weatherDataCache.get(city);

        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return generateAndSaveWeatherData(city);
        } else {
            return weatherData;
        }
    }
}
