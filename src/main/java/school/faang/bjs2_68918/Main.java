package school.faang.bjs2_68918;

import java.util.concurrent.TimeUnit;

/**
 * Задача "Кэшируем, кэшируем"
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache();
        FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

        System.out.println(standardWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Санкт-Петербург", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Санкт-Петербург", 1000));
        System.out.println(frequentUpdateWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(frequentUpdateWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(frequentUpdateWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Москва", 1000));
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println(standardWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Москва", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Санкт-Петербург", 1000));

    }
}
