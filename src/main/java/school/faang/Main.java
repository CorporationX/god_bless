package school.faang;

import school.faang.service.FrequentUpdateWeatherCache;
import school.faang.service.StandardWeatherCache;
import school.faang.service.WeatherCacheTemplate;
import school.faang.service.WeatherData;
import school.faang.service.WeatherProvider;
import school.faang.service.WeatherService;


public class Main {
    public static void main(String[] args) {
        WeatherProvider weatherService = new WeatherService();

        WeatherCacheTemplate standardCache = new StandardWeatherCache(weatherService);
        WeatherData data1 = standardCache.getWeatherData("Екатеринбург", 60000);
        System.out.println(data1);

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(weatherService);
        WeatherData data2 = frequentCache.getWeatherData("Москва", 60000);
        System.out.println(data2);
    }
}