package school.faang.task_44837;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {
    protected final HashMap<String, WeatherData> cache = new HashMap<>();
    protected final WeatherProvider weatherProvider;

    public WeatherCacheTemplate(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cacheData = cache.get(city);

        if (cacheData != null && !isCacheExpired(cacheData, maxCacheAgeMillis)) {
            return cacheData;
        } else {
            WeatherData freshData = fetchWeatherData(city); // Используем абстрактный метод
            updateCache(city, freshData);
            return freshData;
        }
    }

    // Проверка на устаревание данных
    protected boolean isCacheExpired(WeatherData wd, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - wd.getTimestamp() > maxCacheAgeMillis;
    }

    // Обновление кеша
    protected void updateCache(String city, WeatherData data) {
        cache.put(city, data);
    }

    // Абстрактный метод для получения свежих данных
    protected abstract WeatherData fetchWeatherData(String city);
}
