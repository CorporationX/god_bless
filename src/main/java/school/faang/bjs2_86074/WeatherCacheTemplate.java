package school.faang.bjs2_86074;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class WeatherCacheTemplate implements WeatherProvider {
    private Map<String, WeatherData> weatherDataCash;
    private WeatherProvider weatherProvider;

    protected WeatherCacheTemplate() {
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (weatherDataCash.containsKey(city)) {
            WeatherData weatherData = weatherDataCash.get(city);
            if (isCacheExpired(weatherData, maxCacheAgeMillis)) {
                return weatherData;
            } else {
                return forceUpdateWeather(city);
            }
        } else {
            System.out.printf("Данных о городе %s нет", city);
            return null;
        }
    }

    public WeatherData forceUpdateWeather(String city) {
        return weatherDataCash.put(city, fetchWeatherData(city));
    }

}
