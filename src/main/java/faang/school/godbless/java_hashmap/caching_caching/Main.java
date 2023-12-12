package faang.school.godbless.java_hashmap.caching_caching;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.java_hashmap.caching_caching.ExternalService.getExternalWD;

public class Main {

    private static Map<String, WeatherData> weatherDataMap = new HashMap<>();


    static {
        weatherDataMap.put("Almaty", new WeatherData("Almaty", 30, 60));
        weatherDataMap.put("Moscow", new WeatherData("Moscow", 20, 70));
        weatherDataMap.put("Abu Dabi", new WeatherData("Abu Dabi", 40, 40));
    }

    public static void main(String[] args) {
        getWeatherData("Pekin");
        printAll();
    }

    static WeatherData getWeatherData(String city) {
        if (city == null) throw new IllegalArgumentException("args is null");
        WeatherData weatherData = null;
        for (Map.Entry<String, WeatherData> entry : weatherDataMap.entrySet()) {
            if (entry.getKey().equals(city)) {
                weatherData = entry.getValue();
                break;
            }
        }

        if (weatherData == null) {
            weatherData = getExternalWD(city);
            weatherDataMap.put(weatherData.getCity(), weatherData);
        }
        return weatherData;
    }


    static void updateCache(String city) {
        if (city == null) throw new IllegalArgumentException("args is null");
        WeatherData weatherData = getExternalWD(city);
        if (weatherData == null) throw new RuntimeException("Error.......");
        weatherDataMap.put(weatherData.getCity(), weatherData);
    }

    static void remove(String city) {
        if (city == null) throw new IllegalArgumentException("args is null");
        if (weatherDataMap.remove(city) == null) {
            System.out.println("not in the cache");
        } else {
            System.out.println("successfully deleted");
        }
    }

    static void printAll() {
        weatherDataMap.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getValue());
        });
    }


}
