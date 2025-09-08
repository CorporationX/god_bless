package school.faang.bjs2_86074;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();

       Map<String, WeatherData> standardData = new HashMap<>();
        standardData.put("Moscow", weatherService.fetchWeatherData("Moscow"));
       standardData.put("Kazan", weatherService.fetchWeatherData("Kazan"));
        WeatherCacheTemplate standard = new StandardWeatherCache(standardData);

       Map<String, WeatherData> frequentData = new HashMap<>();
       frequentData.put("Sochi", weatherService.fetchWeatherData("Sochi"));
       frequentData.put("Tver", weatherService.fetchWeatherData("Tver"));
       WeatherCacheTemplate frequent = new FrequentUpdateWeatherCache(frequentData);

        System.out.println("Frequent");
        System.out.println(frequent.getWeatherDataCache());

        frequent.getWeatherData("Tver", 3000);

        System.out.println(frequent.getWeatherDataCache());

        System.out.println("Standard");
        System.out.println(standard.getWeatherDataCache());

        standard.getWeatherData("Tver", 3000);

        System.out.println(standard.getWeatherDataCache());
        //ОО прикольно получилось
        // Я так понял разница такая, что если в паттерне стратегия имеются две стратегии
        // и они абсолютно разные, то берется стратегия
        // а если они различаются буквально на строчку или две, то лучше создать абстрактный класс и реализовать шаблонную
    }
}
