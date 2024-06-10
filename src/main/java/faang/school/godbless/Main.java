package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap<String, WeatherData> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getWeatherDataInfo("Moscow"));
        getWeatherDataInfo("London");
        getWeatherDataInfo("Texas");
        System.out.println();

        updateInfo("Moscow", new WeatherData("Moscow", 18, 10));
        System.out.println(getWeatherDataInfo("Moscow"));
        deleteInfo("Texas");
        getCityOnCache();
    }

    public static WeatherData getWeatherDataInfo(String city) {
        if (city == null)
            return null;

        if (cache.containsKey(city)) {
            return cache.get(city);
        } else {
            WeatherData newInfo = Stub.getInfoWeatherData(city);
            cache.put(city, newInfo);
            return newInfo;
        }
    }

    public static void updateInfo(String city, WeatherData newInfo) {
        if (city != null && newInfo != null) {
            cache.put(city, newInfo);
        } else {
            System.out.println("Данные не заполены");
        }
    }

    public static void deleteInfo(String city) {
        if (city != null && cache.containsKey(city)) {
            cache.remove(city);
        } else {
            System.out.println("Город не найден");
        }
    }

    public static void getCityOnCache() {
        for (Map.Entry<String, WeatherData> city : cache.entrySet())
            System.out.println(city.getKey());
    }
}
