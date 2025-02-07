package school.faang.sprint.first.cachingcaching;

import school.faang.sprint.first.cachingcaching.service.FrequentUpdateWeatherCache;
import school.faang.sprint.first.cachingcaching.service.StandardWeatherCache;
import school.faang.sprint.first.cachingcaching.service.WeatherCacheTemplate;
import school.faang.sprint.first.cachingcaching.service.WeatherProvider;
import school.faang.sprint.first.cachingcaching.service.WeatherService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider weatherProvider = new WeatherService();
        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(weatherProvider);
        System.out.println(standardWeatherCache.getWeatherData("Крд", System.currentTimeMillis() - 1000));
        Thread.sleep(500);
        System.out.println(standardWeatherCache.getWeatherData("Крд", System.currentTimeMillis() - 1000));
        Thread.sleep(1500);
        System.out.println(standardWeatherCache.getWeatherData("Крд", System.currentTimeMillis() - 1000));

        WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(weatherProvider);
        System.out.println(frequentUpdateWeatherCache.getWeatherData("СПб", System.currentTimeMillis() - 100));
        Thread.sleep(50);
        System.out.println(frequentUpdateWeatherCache.getWeatherData("СПб", System.currentTimeMillis() - 100));
        Thread.sleep(150);
        System.out.println(frequentUpdateWeatherCache.getWeatherData("СПб", System.currentTimeMillis() - 100));
    }
}
