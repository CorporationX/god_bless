package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Set;

public class WeatherCache {
    HashMap<String, WeatherData> cache = new HashMap<>();

    public WeatherData showWeather(String city) {
        return cache.containsKey(city) ? cache.get(city) : WeatherService.info();
    }

    //обновление информации о погоде в кэше для определённого города;
    public void updateWeatherCache(WeatherData weatherData) {
        cache.put(weatherData.getCity(), weatherData);
    }

    //удаление информации о погоде из кэша по названию города;
    public void deleteWeatherCache(String city) {
        if (cache.containsKey(city)) {
            cache.remove(city);
        } else {
            throw new IllegalArgumentException("В кэше нет данных о городе");
        }
    }
    //вывод списка всех городов, для которых доступна информация о погоде в кэше
    public void showAvailableCityCache() {
        Set<String> cities = cache.keySet();
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
