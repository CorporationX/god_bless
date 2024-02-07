package faang.school.godbless.hash_map.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CACHE_WEATHER = new HashMap<>();
    private static final MockService MOCK_SERVICE = new MockService();

    public static void main(String[] args) {
        System.out.println(getWeather("Вышний Волочек"));
        System.out.println(getWeather("Москва"));
        System.out.println(getWeather("Санкт-Петербург"));
        System.out.println("------------------------------------------");
        System.out.println(getWeather("Вышний Волочек"));
        updateWeatherCache("Москва");
        System.out.println("------------------------------------------");
        infoWeatherCache();
        System.out.println("------------------------------------------");
        deleteWeatherCache("Санкт-Петербург");
        infoWeatherCache();
    }

    private static String getWeather(String name) {
        if (CACHE_WEATHER.containsKey(name)) {
            return CACHE_WEATHER.get(name).toString();
        }
        WeatherData weatherData = MOCK_SERVICE.getWeatherFromDatabase(name);
        CACHE_WEATHER.put(name, weatherData);
        return weatherData.toString();
    }

    private static void updateWeatherCache(String name){
        WeatherData weatherData = MOCK_SERVICE.getWeatherFromDatabase(name);
        CACHE_WEATHER.put(name, weatherData);
    }

    private static void deleteWeatherCache(String name){
        CACHE_WEATHER.remove(name);
    }

    private static void infoWeatherCache(){
        for(Map.Entry<String, WeatherData> entry: CACHE_WEATHER.entrySet()){
            System.out.println(entry.getValue().toString());
        }
    }
}
