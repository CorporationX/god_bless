package faang.school.hashmap.cachingcaching;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, WeatherData> groupWeatherDataByCity = new HashMap<>();
    private static final InfoWeatherData infoWeatherData = new InfoWeatherData();

    public static void main(String[] args) {

        addWeatherInformationCity("Grodno");
        addWeatherInformationCity("Gomel");
        addWeatherInformationCity("Vitebsk");

        System.out.println(printWeatherCityByCity("Grodno"));

        deleteWeatherInformationCity("Grodno");
        deleteWeatherInformationCity(null);

        System.out.println(printWeatherCityByCity(null));
        System.out.println(printWeatherCityByCity("Grodno"));

        printInfoWeatherCityCache();
    }

    private static String printWeatherCityByCity(String city) {
        if (city != null && !city.isBlank()) {
            if (groupWeatherDataByCity.containsKey(city)) {
                System.out.println("Такой город есть в кэше");
                return groupWeatherDataByCity.get(city).toString();
            } else {
                accessingCacheWeatherData(city);
            }
        }
        return null;
    }

    private static void accessingCacheWeatherData(String city) {
        System.out.println("Обращаемся за данными в кэш");
        WeatherData dataCity = infoWeatherData.checkingWeatherDataCache(city);
        groupWeatherDataByCity.put(city, dataCity);
        groupWeatherDataByCity.get(city).toString();
    }

    private static void addWeatherInformationCity(String city) {
        if (city != null && !city.isBlank()) {
            WeatherData dataCity = infoWeatherData.checkingWeatherDataCache(city);
            groupWeatherDataByCity.put(city, dataCity);
        }
    }

    private static void deleteWeatherInformationCity(String city) {
        if (groupWeatherDataByCity.containsKey(city)) {
            groupWeatherDataByCity.remove(city);
        } else
            System.out.println("В кэше нет данных по этому городу " + city);

    }

    private static void printInfoWeatherCityCache() {
        for (Map.Entry<String, WeatherData> city : groupWeatherDataByCity.entrySet()) {
            System.out.println(city);
        }
    }
}
