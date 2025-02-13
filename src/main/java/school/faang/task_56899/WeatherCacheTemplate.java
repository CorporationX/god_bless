package school.faang.task_56899;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected final Logger logger = LoggerFactory.getLogger(WeatherCacheTemplate.class);
    protected final Map<String, WeatherData> weatherDataCache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (!weatherDataCache.containsKey(city)) {
            logger.warn("Получение данных о погоде: данных о погоде для \"{}\" нет.", city);
            updateWeatherData(city);
            return weatherDataCache.get(city);
        } else if (isCacheExpired(weatherDataCache.get(city), maxCacheAgeMillis)) {
            logger.warn("Получение данных о погоде: данные о погоде для \"{}\" устарели.", city);
            updateWeatherData(city);
            return weatherDataCache.get(city);
        }
        logger.info("Получение данных о погоде: данные для \"{}\" получены.", city);
        return weatherDataCache.get(city);

    }

    public void updateWeatherData(String city) {
        WeatherData newWeatherData = new WeatherService().fetchWeatherData(city);
        weatherDataCache.put(city, newWeatherData);
        logger.info("Обновление данных о погоде: данные для \"{}\" обновлены.", city);
    }

    public void printAllWeatherData() {
        weatherDataCache.forEach((city, weatherData) -> System.out.println(city + " " + weatherData));
    }

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    abstract void cleanExpiredCache(long maxCacheAgeMillis);
}
