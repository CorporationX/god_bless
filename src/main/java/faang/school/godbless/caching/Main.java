package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    private static Random rnd = new Random();
    private static Map<String, WeatherData> cachedWeatherDataByCityName
            = new HashMap<>();

    public static void main(String[] args) {
        //TestGetSameCityDataTwice
        System.out.println(getWeatherData("1"));
        System.out.println(getWeatherData("1"));

        //TestGetUpdatedData
        update("1", 24.6, 51.4);
        System.out.println(getWeatherData("1"));


        //TestGetNamesCachedData
        getWeatherData("2");
        getWeatherData("3");
        System.out.println(getCachedCityNames());

        //TestDeleteData
        System.out.println(cachedWeatherDataByCityName);
        delete("1");
        System.out.println(cachedWeatherDataByCityName);
    }

    // Получаем данные из кэша,
    // а при отсутствии запрашиваем их из внешного источника
    static WeatherData getWeatherData(String cityName) {
        if (cityName == null) {
            throw new IllegalArgumentException("City name cant be NULL");
        }

        return cachedWeatherDataByCityName.computeIfAbsent(
                cityName, key -> requestExternalData(cityName));
    }

    // Получаем список всех городов, для которых есть информация в кэше.
    static List<String> getCachedCityNames() {
        return cachedWeatherDataByCityName.keySet().stream().toList();
    }

    // Обновляем данные кэша
    static void update(String cityName, double temp, double humidity) {
        if (cityName == null) {
            throw new IllegalArgumentException("City name cant be NULL");
        }

        WeatherData weatherData = cachedWeatherDataByCityName.get(cityName);
        weatherData.setTemperature(temp);
        weatherData.setHumidity(humidity);
    }

    // Удаляем данные кэша
    static void delete(String cityName) {
        if (cityName == null) {
            throw new IllegalArgumentException("City name cant be NULL");
        }

        cachedWeatherDataByCityName.remove(cityName);
    }

    // Обращаемся к "внешнему источнику"
    private static WeatherData requestExternalData(String cityName) {
        System.out.println("Request to external source");
        return new WeatherData(new City(cityName), getRandomTemp(), getRandomHumidity());
    }

    // random temp -50.0 - +50.0
    private static double getRandomTemp() {
        return (double) rnd.nextInt(-500, 500 + 1) / 10;
    }

    // random humidity 0.0 - 100.0
    private static double getRandomHumidity() {
        return (double) rnd.nextInt(100 + 1) / 10;
    }
}
