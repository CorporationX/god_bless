package faang.school.godbless.java_sql.task_4;

import java.util.HashMap;

public class WeatherController {

    static WeatherData getTemperatureFromCity(HashMap<String, WeatherData> cache, String city) {
        if (cache.containsKey(city)) {
            return cache.get(city);
        } else {
            return WeatherRepository.getWeatherFromCity(city);
        }
    }

    static void deleteTemperatureByCity(HashMap<String, WeatherData> cache, String city) {
        cache.remove(city);
    }

    static void updateTemperatureByWeather(HashMap<String, WeatherData> cache,
                                           WeatherData weatherData) {
        cache.replace(weatherData.city(), weatherData);
    }

    static void printTemperatureCache(HashMap<String, WeatherData> cache) {
        System.out.println(cache);
    }
}
