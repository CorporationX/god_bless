package cache;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, WeatherData> WEATHER_DATA_CACHE = new HashMap<>();
    private static final MockService service = new MockService();

    public static void main(String[] args) {

        WEATHER_DATA_CACHE.put("New York", new WeatherData("New York", 20, 65));
        WEATHER_DATA_CACHE.put("Sochi", new WeatherData("Sochi", 22, 80));
        printInfoAboutWeatherWhichStorageInCache();

        updateInfoAboutWeather("New York");
        printInfoAboutWeatherWhichStorageInCache();

        findWeatherInCache("Moscow");
        findWeatherInCache("Chicago");
        findWeatherInCache("London");
        printInfoAboutWeatherWhichStorageInCache();

        deleteInfoAboutWeather("Chicago");
        printInfoAboutWeatherWhichStorageInCache();
    }

    public static String findWeatherInCache(String city) {
        if (!WEATHER_DATA_CACHE.containsKey(city)) {
            WEATHER_DATA_CACHE.put(city, service.getWeather(city));
        }
        return printInfoAboutWeather(city);
    }

    private static String printInfoAboutWeather(String city) {
        WeatherData infoInCache = WEATHER_DATA_CACHE.get(city);
        return "Город: " + infoInCache.getCity() +
                "\nТемпература: " + infoInCache.getTemperature() +
                "\nВлажность: " + infoInCache.getHumidity();
    }

    public static void updateInfoAboutWeather(String city) {
        WEATHER_DATA_CACHE.put(city, service.getWeather(city));
    }

    public static void deleteInfoAboutWeather(String city) {
        WEATHER_DATA_CACHE.remove(city);
    }

    public static void printInfoAboutWeatherWhichStorageInCache() {
        System.out.println("\nIнформация о погоде в кэше:");
        for (Map.Entry<String, WeatherData> entry : WEATHER_DATA_CACHE.entrySet()) {
            System.out.println("\nГород: " + entry.getValue().getCity() +
                    "\nТемпература: " + entry.getValue().getTemperature() +
                    "\nВлажность: " + entry.getValue().getHumidity());
        }
    }
}

