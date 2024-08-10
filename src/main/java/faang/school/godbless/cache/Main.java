package faang.school.godbless.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static  Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public static void main(String[] args) {
    }

    public static WeatherData getWeatherData(String city) {
        String normalizedCity = city.trim().toLowerCase();

        if (weatherDataMap.containsKey(normalizedCity)) {
            return weatherDataMap.get(normalizedCity);
        }
        else{
            weatherDataMap.put(city, callWeatherAPI(normalizedCity));
            return weatherDataMap.get(city);
        }
    }

    public static WeatherData callWeatherAPI(String city) {
        Random theMostPreciseWeatherData = new Random();
        int temperatureData = theMostPreciseWeatherData.nextInt(-70, 50);
        int humidityData = theMostPreciseWeatherData.nextInt(0, 100);

        return new WeatherData(city, temperatureData, humidityData);
    }

    public static void updateCache(String city) {
        String normalizedCity = city.trim().toLowerCase();
        weatherDataMap.put(normalizedCity, callWeatherAPI(normalizedCity));
    }

    public static void deleteWeatherData(String city) {
        String normalizedCity = city.trim().toLowerCase();
        weatherDataMap.remove(normalizedCity);
    }

    public static void getCacheInfo() {
        for (Map.Entry<String, WeatherData> city : weatherDataMap.entrySet()) {
            System.out.println(city.getValue().getCity());
        }
    }
}
