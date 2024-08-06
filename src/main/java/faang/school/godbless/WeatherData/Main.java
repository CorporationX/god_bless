package faang.school.godbless.WeatherData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, WeatherData> theWetherOfCities = new HashMap<>();
    private static WeatherService weatherService = new WeatherService();


    public static void main(String[] args) {
        System.out.println(getCityInfo("New York"));
        System.out.println(getCityInfo("London"));
        System.out.println(getCityInfo("New York")); // кэшированные данные

        updateWetherData("New York");
        System.out.println(getCityInfo("New York")); // обновленные данные

        removeWeatherData("London");
        System.out.println(getCityInfo("London")); //  новые данные

        System.out.println(getAllCities());
    }

    public static WeatherData getCityInfo(String city) {
        if (theWetherOfCities.containsKey(city)) {
            return theWetherOfCities.get(city);

        } else {
            WeatherData data = weatherService.getWeatherData(city);
            theWetherOfCities.put(city, data);
            return data;

        }

    }

    public static void updateWetherData(String city) {
        WeatherData data = weatherService.getWeatherData(city);
        theWetherOfCities.put(city, data);
    }

    public static void removeWeatherData(String city) {
        theWetherOfCities.remove(city);
    }

    public static Set<String> getAllCities() {
        return theWetherOfCities.keySet();
    }
}

