package faang.school.hashmap.cachingcaching;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static private final HashMap<String, WeatherData> mapWeatherData = new HashMap<>();

    public static void main(String[] args) {

        addWeatherInformationCity("Grodno");
        addWeatherInformationCity("Gomel");
        addWeatherInformationCity("Vitebsk");

        System.out.println(printWeatherCity("Grodno"));

        deleteWeatherInformationCity("Grodno");

        System.out.println(printWeatherCity("Mink"));
        System.out.println(printWeatherCity("Grodno"));

        printInfoWeatherCityCache();
    }

    private static String printWeatherCity(String city) {
        if (!(city.isBlank())) {
            if (mapWeatherData.containsKey(city)) {
                System.out.println("Такой город есть в кэше");
                return mapWeatherData.get(city).toString();
            } else {
                System.out.println("Такого города нет в кэше");
                InfoWeatherData infoWeatherData = new InfoWeatherData();
                WeatherData dataCity = infoWeatherData.weatherData(city);
                if (dataCity != null) {
                    mapWeatherData.put(city, dataCity);
                    return mapWeatherData.get(city).toString();
                }
            }
        }
        return null;
    }

    private static void addWeatherInformationCity(String city) {
        if (!(city.isBlank())) {
            InfoWeatherData infoWeatherData = new InfoWeatherData();
            WeatherData dataCity = infoWeatherData.weatherData(city);
            if (dataCity != null) {
                mapWeatherData.put(city, dataCity);
            }
        }
    }

    private static void deleteWeatherInformationCity(String city) {
        if (!(city.isBlank())) {
            if (mapWeatherData.containsKey(city)) {
                mapWeatherData.remove(city);
            } else
                System.out.println("В кэше нет данных по этому городу " + city);
        }
    }

    private static void printInfoWeatherCityCache() {
        for (Map.Entry<String, WeatherData> city : mapWeatherData.entrySet()) {
            System.out.println(city);
        }
    }
}
