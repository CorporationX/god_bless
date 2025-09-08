package school.faang.bjs2_86074;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;

import static school.faang.bjs2_86074.ConstantWearher.MAX_HUMIDITY;
import static school.faang.bjs2_86074.ConstantWearher.MAX_TEMPARATURE;
import static school.faang.bjs2_86074.ConstantWearher.MIN_HUMIDITY;
import static school.faang.bjs2_86074.ConstantWearher.MIN_TEMPARATURE;

@Getter
public abstract class WeatherCacheTemplate implements WeatherProvider {
    private Map<String, WeatherData> weatherDataCache;
    private final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider, Map<String, WeatherData> weatherDataCache) {
        this.weatherProvider = weatherProvider;
        this.weatherDataCache = weatherDataCache;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {

        WeatherData weatherData = weatherDataCache.get(city);

        if (Objects.nonNull(weatherData) && isCacheExpired(weatherData, maxCacheAgeMillis)) {
            return weatherData;
        } else {
            return forceUpdateWeather(city);
        }
    }

    public WeatherData forceUpdateWeather(String city) {
        return weatherDataCache.put(city, fetchWeatherData(city));
    }
}
