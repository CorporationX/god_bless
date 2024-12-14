package school.faang.sprint_1.task_44814;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    private final Map<String, WeatherData> dataWeatherBase = new HashMap<>();

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    private WeatherProvider weatherProvider;


    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData data = dataWeatherBase.get(city);

        if (data == null || isCacheExpired(data, maxCacheAgeMillis)) {
            data = weatherProvider.fetchWeatherData(city);
            dataWeatherBase.put(city, data);
            System.out.println("Погода для " + city + " обновлена");
        }
        System.out.println("Погода для " + city + " взята из базы");

        return data;
    }

    public abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public void forceUpdateWeather(String city) {
        WeatherData weatherData = weatherProvider.fetchWeatherData(city);

        dataWeatherBase.put(city, weatherData);
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        dataWeatherBase.entrySet().removeIf(entry ->
                (currentTime - entry.getValue().getTimestamp()) > maxCacheAgeMillis
        );
    }
}
