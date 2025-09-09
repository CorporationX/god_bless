package school.faang.bjs2_86050;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private WeatherProvider weatherProvider;
    private Map<String, WeatherData> weatherCache = new HashMap<>();

    abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        //TODO проверка есть ли в кеше данные и если устарели, вызывает WeatherProvider для актуализации
        return null;
    }

    public WeatherData forceUpdateWeather(String city) {
        //TODO принудительно обновляет данные
        return null;
    }
}
