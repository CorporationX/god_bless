package school.faang.cachecache;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        try {
            StandardWeatherCache standardWeatherCache = new StandardWeatherCache();
            System.out.println(standardWeatherCache.getWeatherData("Санкт-Петербург", (long) 1000000000.0));
            standardWeatherCache.clearExpiredCache((long) 10.0);
            System.out.println("--------------------------");
            System.out.println(standardWeatherCache.getWeatherData("Санкт-Петербург", (long) 10000000.0));
            Thread.sleep(2000);
            System.out.println(standardWeatherCache.getWeatherData("Санкт-Петербург", (long) 2000.0));
            System.out.println(standardWeatherCache.getWeatherData("Санкт-Петербург", (long) 100000.0));
            System.out.println(standardWeatherCache.getWeatherData("Санкт-Петербург", (long) 1000.0));
            System.out.println(standardWeatherCache.getWeatherData("Москва", (long) 1000000.0));
            Thread.sleep(2000);
            System.out.println(standardWeatherCache.getWeatherData("Москва", (long) 100.0));
            System.out.println("--------------------------");

            WeatherProvider weatherProvider = new WeatherService();
            System.out.println(weatherProvider.fetchWeatherData("Москва"));
            System.out.println(weatherProvider.fetchWeatherData("Калининград"));
            System.out.println("--------------------------");

            FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
            System.out.println(frequentUpdateWeatherCache.getWeatherData("Казань", (long) 1000000.0));
            Thread.sleep(2000);
            System.out.println(frequentUpdateWeatherCache.getWeatherData("Казань", (long) 100.0));
            System.out.println(frequentUpdateWeatherCache.getWeatherData("Казань", (long) 10000.0));
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
    }
}