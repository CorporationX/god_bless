package school.faang.bjs2_86074;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.Objects;


@SuperBuilder
@Getter
public abstract class WeatherCacheTemplate {
    private final Map<String, WeatherData> weatherDataCache;

    public WeatherCacheTemplate(Map<String, WeatherData> weatherDataCache) {
        this.weatherDataCache = weatherDataCache;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {

        WeatherData weatherData = weatherDataCache.get(city);

        if (Objects.isNull(weatherData) || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            System.out.println(2);
            return forceUpdateWeather(city);

        } else {
            System.out.println(1);
            return weatherData;
        }
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData weatherData = fetchWeatherData(city);
        System.out.println(weatherData);
        return weatherDataCache.put(city, fetchWeatherData(city));
    }

     public WeatherData fetchWeatherData(String city) {
         return RandomDataGenerator.generatorData(city);
    }
}
