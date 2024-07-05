package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weather {
    public static Map<String, WeatherData> weatherMap = new HashMap<>();

    public static WeatherData findWeather(String city) {
        if (weatherMap.containsKey(city)) {
            return weatherMap.get(city);
        } else {
            return getWeatherExternal(city);
        }
    }

    public static WeatherData getWeatherExternal(String city) {
        //that is mock
        return new WeatherData(city, 45, 78);
    }

    public static void addWeatherIntoCache(String city, WeatherData data) {
        weatherMap.put(city, data);
    }

    public static void removeWeatherFromCache(String city) {
        weatherMap.remove(city);
    }

    public static List<String> citiesWithCachedWeather() {
        List<String> cities = new ArrayList<>();
        for (Map.Entry<String, WeatherData> entry : weatherMap.entrySet()) {
            cities.add(entry.getKey());
        }
        return cities;
    }
}
