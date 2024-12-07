package school.faang.task_44831.cache;

import org.apache.commons.lang3.StringUtils;
import school.faang.task_44831.entity.WeatherData;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (StringUtils.isBlank(city)) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }

        return generateAndSaveWeatherData(city);
    }
}
