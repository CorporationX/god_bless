package school.faang.cachingweather;

import lombok.Data;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

@Data
public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> cityWeather;
    private WeatherService weatherService;
    private long maxCacheAgeMillis;

    public WeatherCacheTemplate() {
        this.cityWeather = new HashMap<String, WeatherData>();
        this.weatherService = new WeatherService();
    }

    public abstract boolean isCacheExpired(WeatherData data);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (cityWeather.containsKey(city)) {
            if (!isCacheExpired(cityWeather.get(city))) {
                return cityWeather.get(city);
            }
        }
        WeatherData weatherData = getWeather(city);
        cityWeather.put(city, weatherData);
        return weatherData;
    }

    public WeatherData getWeatherData(String city) {
        return getWeatherData(city, this.maxCacheAgeMillis);
    }

    public WeatherData forceUpdateWeather(String city) {
        WeatherData weatherData = getWeather(city);
        return weatherData;
    }

    public WeatherData getWeather(String city) {
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        cityWeather.put(city, weatherData);
        return weatherData;
    }

    public void clearExpiredCache() {
        Iterator<Map.Entry<String, WeatherData>> iterator = cityWeather.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WeatherData> entry = iterator.next();
            if (isCacheExpired(entry.getValue())) {
                iterator.remove();
            }
        }
    }

}
