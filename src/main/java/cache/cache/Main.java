package cache.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, WeatherData> weatherDataCache = new HashMap<>();


    public static void main(String[] args) {

        WeatherData weatherData1 = new WeatherData("New-York", 12, 10);
        WeatherData weatherData2 = new WeatherData("Moscow", 50, 50);
        WeatherData weatherData3 = new WeatherData("Saint Petersburg", 25, 100);

        weatherDataCache.put("New-York", weatherData1);
        weatherDataCache.put("Moscow", weatherData2);
        weatherDataCache.put("Saint Petersburg", weatherData3);

        System.out.println(weatherInfo("New-York"));

        updateWeatherData("Moscow");
        deleteWeatherInfoForCity("New-York");
        printWeatherInfoForCity(weatherDataCache);

        printCacheData(weatherDataCache);

        clearCacheWeather(weatherDataCache);

        printWeatherInfoForCity(weatherDataCache);

    }

    public static WeatherData weatherInfo(String city) {
        if (!weatherDataCache.containsKey(city)) {
            WeatherData newWeatherData = WeatherCentre.getWeatherData(city);
            weatherDataCache.put(city, newWeatherData);
        }
        System.out.print(city + ": ");
        return weatherDataCache.get(city);
    }

    public static void updateWeatherData(String city) {
        WeatherData newWeather = WeatherCentre.getWeatherData(city);
        weatherDataCache.replace(city, newWeather);
        System.out.println("\nПогода для " + city + " обновлена\n");
    }

    public static void deleteWeatherInfoForCity(String city) {
        if(weatherDataCache.containsKey(city)) {
            weatherDataCache.replace(city, null);
            System.out.println("Данные о погоде для города " + city + " удалены из кэша\n");
        }
        System.out.println("Данных о городе " + city + " в кэшэ нет");
    }

    public static void printWeatherInfoForCity(Map<String, WeatherData> weatherCache) {
        if (weatherCache == null || weatherCache.isEmpty()) {
            System.out.println("Кэш пустой");
            return;
        }
        System.out.println("\nСписок городов, о которых есть данные в кэше: ");
        for (WeatherData weatherData : weatherCache.values()) {
            if (weatherData != null) {
                System.out.println(weatherData.getCity() + ": " + weatherData);
            }
        }
    }

    public static void printCacheData(Map<String, WeatherData> weatherCache) {
        if (weatherCache == null || weatherCache.isEmpty()) {
            System.out.println("Кэш пустой");
        }
        System.out.println("\nСписок всех данных из кэша: ");
        for (Map.Entry<String, WeatherData> entry : weatherCache.entrySet()) {
            WeatherData weatherData = entry.getValue();
            if (weatherData != null) {
                System.out.println(entry.getKey() + " : " + weatherData);
            } else {
                System.out.println(entry.getKey() + " : данных к кэше нет");
            }
        }
    }

    public static void clearCacheWeather(Map<String, WeatherData> weatherCache) {
        weatherCache.clear();
    }
}
