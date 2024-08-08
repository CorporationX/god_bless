package faang.school.godbless.task19010;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, WeatherData> cache = new HashMap<>();

    public static WeatherData getWeather(String city){
        WeatherData weatherData = WeatherService.getWeather(city);
        if (cache.containsKey(city))
                return cache.get(city);
        else {cache.put(city,weatherData);
                return cache.get(city);
        }
    }

    public static void updateWeather(String city){
        cache.put(city, WeatherService.getWeather(city));
    }

    public static void deleteWeather(String city){
        cache.remove(city);
    }

    public static Map<String, WeatherData> getWeatherAllCities(){
        return cache;
    }

    public static void main(String[] args) {
        System.out.println(getWeather("Moscow"));
        updateWeather("Moscow");
        deleteWeather("Moscow");
        System.out.println(getWeatherAllCities());
    }
}
