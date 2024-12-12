package school.faang.sprint1.bjs_44850;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        long maxMillis = 1733934640345L;
        WeatherProvider weatherProvider = new WeatherService();
        WeatherData weatherData;

        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(maxMillis, weatherProvider);
        WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(weatherProvider);

        weatherData = standardWeatherCache.getWeatherData("Moscow");
        printData(weatherData);

        weatherData = frequentUpdateWeatherCache.getWeatherData("Voronezh");
        printData(weatherData);
    }

    private static void printData(WeatherData weatherData) {
        System.out.println("Город: " + weatherData.getCity());
        System.out.println("Температура: " + weatherData.getTemperature());
        System.out.println("Влажность: " + weatherData.getHumidity());
        System.out.println("Последнее обновление: " + new Date(weatherData.getTimestamp()));
        System.out.println("=============");
    }
}
