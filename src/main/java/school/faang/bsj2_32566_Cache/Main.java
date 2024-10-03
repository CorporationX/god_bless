package school.faang.bsj2_32566_Cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> cityWeatherCache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(cityWeatherCache);
        System.out.println(showWeather("Gotham"));

        updateData("Metropolis");
        updateData("New York");
        updateData("Gotham");
        updateData("Night City");

        System.out.println(cityWeatherCache);

        deleteData("Night City");

        System.out.println(cityWeatherCache);

        System.out.println(listCachedCities());
    }

    private static WeatherData showWeather(String city) {
        if (!cityWeatherCache.containsKey(city)) {
            WeatherData newData = WeatherWebMock.provideData(city);
            cityWeatherCache.put(city, newData);
        }
        return cityWeatherCache.get(city);
    }

    private static void updateData(String city) {
        WeatherData newData = WeatherWebMock.provideData(city);
        cityWeatherCache.put(city, newData);
    }

    private static void deleteData(String city) {
        cityWeatherCache.remove(city);
    }

    private static List<String> listCachedCities() {
        List<String> cityList = new ArrayList<>();
        cityList.addAll(cityWeatherCache.keySet());
        return cityList;
    }
}
