package faang.school.godbless.BJS2_18996;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CITIES_WEATHER = new HashMap<>();

    public static void main(String[] args) {
        CITIES_WEATHER.put("Amsterdam", new WeatherData("Amsterdam", 25, 30));
        CITIES_WEATHER.put("New York", new WeatherData("New York", 15, 60));
        CITIES_WEATHER.put("Moscow", new WeatherData("Moscow", 27, 35));
        System.out.println(getWeatherData("Minsk"));
        deleteWeatherDataInCache("New York");
        printAllCitiesFromCache();
    }

    private static WeatherData getWeatherData(String city) {
        if (!CITIES_WEATHER.containsKey(city)) {
            updateWeatherDataInCache(city);
        }
        return CITIES_WEATHER.get(city);
    }

    private static void updateWeatherDataInCache(String city) {
        CITIES_WEATHER.put(city, WeatherService.getCurrentWeatherData(city));
    }

    private static void deleteWeatherDataInCache(String city) {
        CITIES_WEATHER.remove(city);
    }

    private static void printAllCitiesFromCache() {
        for (var city : CITIES_WEATHER.entrySet()) {
            System.out.println(city.getKey());
        }
    }
}
