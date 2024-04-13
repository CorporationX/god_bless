package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getWeather("Moscow"));
        System.out.println(getWeather("Saint-Petersburg"));
        removeData("Moscow");
        System.out.println("\nReport after changes: \n" + weatherCache);
    }

    public static String getWeather(String city){
        WeatherData weatherData = weatherCache.get(city);

        if (weatherData == null){
            WeatherData wd = MockService.doSomeLongOperation(city);
            weatherCache.put(city, wd);
            return wd.toString();
        }
        return weatherData.toString();
    }

    public static void removeData(String city){
        weatherCache.remove(city);
    }
}
