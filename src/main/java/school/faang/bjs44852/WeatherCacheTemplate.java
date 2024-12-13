package school.faang.bjs44852;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class WeatherCacheTemplate {
    protected final Map<String, WeatherData> data = new HashMap<>();
    private final WeatherProvider weatherProvider;

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (data.containsKey(city)) {
            WeatherData cityData = data.get(city);
            if (checkIfDataActual(city, maxCacheAgeMillis)) {
                return cityData;
            }
        }
        WeatherData weather = weatherProvider.fetchWeatherData(city);
        data.put(city, weather);
        return weather;
    }

    protected WeatherData fetchAndCacheWeatherData(String city) {
        WeatherData weather = weatherProvider.fetchWeatherData(city);
        data.put(city, weather);
        return weather;
    }

    public void clearExpiredCache(long maxMillis) {
        data.entrySet().removeIf(pair -> !checkIfDataActual(pair.getValue().getCity(), maxMillis));
    }

    public abstract boolean checkIfDataActual(String city, long maxMillis);

    public abstract void updateData(long maxMillis);

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }
}
