package school.faang.task44870;

import school.faang.task44870.controller.FrequentUpdateWeatherCache;
import school.faang.task44870.controller.StandardWeatherCache;

public class Main {
    public static void main(String[] args) {

        FrequentUpdateWeatherCache weatherNoCache = new FrequentUpdateWeatherCache();

        System.out.println(weatherNoCache.getWeatherData("Moscow", 1000));
        System.out.println(weatherNoCache.getWeatherData("Moscow", 1000));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(weatherNoCache.getWeatherData("Moscow", 1000));
        System.out.println(weatherNoCache.getWeatherData("Moscow", 1000));

        StandardWeatherCache weatherCache = new StandardWeatherCache();

        System.out.println(weatherCache.getWeatherData("Moscow", 1000));
        System.out.println(weatherCache.getWeatherData("Moscow", 1000));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(weatherCache.getWeatherData("Moscow", 1000));
        System.out.println(weatherCache.getWeatherData("Moscow", 1000));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        weatherCache.clearExpiredCache(1000);

        System.out.println(weatherCache.getWeatherData("Moscow", 1000));



    }
}
