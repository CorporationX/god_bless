package faang.school.godbless.cacheCache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> cacheWeather = new HashMap<>();

    public static void main(String[] args) {
        WeatherData weatherInLondon = new WeatherData("London", 13, 31);
        WeatherData weatherInNewYork = new WeatherData("New York", 16, 29);
        WeatherData weatherInMoscow = new WeatherData("Moscow", 17, 27);

        cacheWeather.put("London", weatherInLondon);
        cacheWeather.put("New York", weatherInNewYork);
        cacheWeather.put("Moscow", weatherInMoscow);

        giveInfoAboutWeather("New York");
        updateInfoAboutWeather("London", 15, 30);
        removeInformationAboutWeather("New York");
        displayAllCitiesInCache();
    }

    private static WeatherData giveInfoAboutWeather(String city) {
        if (cacheWeather.containsKey(city)) {
            return cacheWeather.get(city);
        } else {
            return MockWeather.giveInfoAboutWeatherOuter(city);
        }
    }

    private static void updateInfoAboutWeather(String city, int temperature, int humidity) {
        if (cacheWeather.containsKey(city)) {
            WeatherData newWeatherData = cacheWeather.get(city);
            newWeatherData.setTemperature(temperature);
            newWeatherData.setHumidity(humidity);
        } else {
            WeatherData newWeatherDataOfNewCity = MockWeather.giveInfoAboutWeatherOuter(city);
            cacheWeather.put(city, newWeatherDataOfNewCity);
        }
    }

    private static void removeInformationAboutWeather(String city) {
        if (cacheWeather.containsKey(city)) {
            cacheWeather.remove(city);
        } else {
            System.out.println("Город не найден в кэше.");
        }
    }

    private static void displayAllCitiesInCache() {
        for (Map.Entry<String, WeatherData> entry : cacheWeather.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}