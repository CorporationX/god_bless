package faang.school.godbless.cachingcaching;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    private static WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        // Получение и вывод информации о погоде в городе
        WeatherData weatherInLondon = getWeather("London");
        System.out.println(weatherInLondon);

        // Обновление информации о погоде в городе
        updateWeather("London");

        // Повторный вывод обновленной информации о погоде
        weatherInLondon = getWeather("London");
        System.out.println(weatherInLondon);

        // Удаление информации о погоде из кэша
        removeWeather("London");

        // Попытка получить удалённую информацию (должен быть новый запрос)
        weatherInLondon = getWeather("London");
        System.out.println(weatherInLondon);

        // Вывод списка всех городов в кэше
        System.out.println("Cities in cache: " + getCachedCities());
    }

    // Метод для получения информации о погоде
    public static WeatherData getWeather(String city) {
        // Проверка наличия информации о городе в кэше
        if (weatherCache.containsKey(city)) {
            System.out.println("Fetching weather data for " + city + " from cache.");
            return weatherCache.get(city);
        } else {
            System.out.println("Fetching weather data for " + city + " from external service.");
            // Получение данных из внешнего сервиса
            WeatherData weatherData = weatherService.getWeather(city);
            // Сохранение данных в кэше
            weatherCache.put(city, weatherData);
            return weatherData;
        }
    }

    // Метод для обновления информации о погоде в кэше
    public static void updateWeather(String city) {
        System.out.println("Updating weather data for " + city + ".");
        // Получение новых данных из внешнего сервиса
        WeatherData weatherData = weatherService.getWeather(city);
        // Обновление данных в кэше
        weatherCache.put(city, weatherData);
    }

    // Метод для удаления информации о погоде из кэша
    public static void removeWeather(String city) {
        System.out.println("Removing weather data for " + city + " from cache.");
        weatherCache.remove(city);
    }

    // Метод для получения списка всех городов в кэше
    public static Set<String> getCachedCities() {
        return weatherCache.keySet();
    }
}