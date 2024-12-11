package school.faang.task_44837;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {
    protected final HashMap<String, WeatherData> cache = new HashMap<>();

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData cacheData = cache.get(city);


        if (cacheData != null && !isCacheExpired(cacheData, maxCacheAgeMillis)) {
            return cacheData;
        } else {
            WeatherService ws = new WeatherService();  //создаем экземпляр класса
            WeatherData freshData = ws.fetchWeatherData(city);  //получаем новый кэш
            updateCache(city, freshData);  //обновляем кэш
            return freshData;
        }
    }

    //проверка на устарение
    protected  boolean isCacheExpired(WeatherData wd, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - wd.getTimestamp() > maxCacheAgeMillis;
    }

    //обновление кеша
    protected void updateCache(String city, WeatherData data) {
        cache.put(city, data);
    }

    protected abstract WeatherData fetchWeatherData(String city);
}
