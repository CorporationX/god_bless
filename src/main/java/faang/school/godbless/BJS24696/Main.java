package faang.school.godbless.BJS24696;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> weatherCache = new HashMap<>();

        String city = "Москва";
        WeatherData weather = WeatherData.getWeatherFromCacheOrExternal(city, weatherCache);
        System.out.println("Погода в городе " + city + ": " + weather);

        String city1 = "Москва";
        WeatherData weather1 = WeatherData.getWeatherFromCacheOrExternal(city1, weatherCache);
        System.out.println("Погода в городе " + city1 + ": " + weather1);

        String city2 = "Питер";
        WeatherData weather2 = WeatherData.getWeatherFromCacheOrExternal(city2, weatherCache);
        System.out.println("Погода в городе " + city2 + ": " + weather2);

        WeatherData.updateWeatherDataInCache(city, weatherCache);

        System.out.println("\nПогода в городах в кеше:");
        WeatherData.printCitiesWithWeather(weatherCache);

        System.out.println("Удаляем данные из кеша о Питере");
        WeatherData.removeWeatherDataFromCache(city2, weatherCache);

        System.out.println("\nПогода в городах в кеше:");
        WeatherData.printCitiesWithWeather(weatherCache);

    }
}
