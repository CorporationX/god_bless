package school.faang.task56921.weather;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class StandardWeatherCache extends WeatherCacheTemplate {
    Logger logger = LoggerFactory.getLogger(StandardWeatherCache.class);

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (getCityInfo().isEmpty()) {
            updateWeatherData(city);
        }
        if (isCacheExpired(getCityInfo().get(city), maxCacheAgeMillis)) {
            updateWeatherData(city);
            logger.info("Получение новых данных");
        }
        return getCityInfo().get(city);
    }
}
