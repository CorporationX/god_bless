package school.faang.m1s1.bsj2_32566_Cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CITY_WEATHER_CACHE = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(CITY_WEATHER_CACHE);
        System.out.println(showWeather("Gotham"));

        updateData("Metropolis");
        updateData("New York");
        updateData("Gotham");
        updateData("Night City");

        System.out.println(CITY_WEATHER_CACHE);

        deleteData("Night City");

        System.out.println(CITY_WEATHER_CACHE);

        System.out.println(listCachedCities());
    }

    private static WeatherData showWeather(String city) {
        if (!CITY_WEATHER_CACHE.containsKey(city)) {
            WeatherData newData = new WeatherService(city).provideData();
            CITY_WEATHER_CACHE.put(city, newData);
        }
        return CITY_WEATHER_CACHE.get(city);
    }

    private static void updateData(String city) {
        WeatherData newData = new WeatherService(city).provideData();
        CITY_WEATHER_CACHE.put(city, newData);
    }

    private static void deleteData(String city) {
        CITY_WEATHER_CACHE.remove(city);
    }

    private static List<String> listCachedCities() {
        List<String> cityList = new ArrayList<>();
        cityList.addAll(CITY_WEATHER_CACHE.keySet());
        return cityList;
    }
}
