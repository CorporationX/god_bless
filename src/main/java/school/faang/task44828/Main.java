package school.faang.task44828;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache();
        WeatherCacheTemplate frequentWeatherCache = new FrequentUpdateWeatherCache(1000);

        System.out.println("Standard 1 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Vyatskie Poluany").toString());
        System.out.println(standardWeatherCache.getWeatherData("Moscow").toString());
        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Berlin").toString());
        System.out.println("Frequent 1 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(frequentWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(frequentWeatherCache.getWeatherData("Vyatskie Poluany").toString());
        System.out.println(frequentWeatherCache.getWeatherData("Moscow").toString());
        System.out.println(frequentWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(frequentWeatherCache.getWeatherData("Berlin").toString());

        Thread.sleep(Duration.ofSeconds(1).toMillis());

        System.out.println("Frequent 2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(frequentWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(frequentWeatherCache.getWeatherData("Vyatskie Poluany").toString());
        System.out.println(frequentWeatherCache.getWeatherData("Moscow").toString());
        System.out.println(frequentWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(frequentWeatherCache.getWeatherData("Berlin").toString());
        Thread.sleep(Duration.ofSeconds(15).toMillis());

        System.out.println("Standard 2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Vyatskie Poluany").toString());
        System.out.println(standardWeatherCache.getWeatherData("Moscow").toString());
        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Berlin").toString());

        standardWeatherCache.clearExpiredCache(1);

        System.out.println("Standard 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Vyatskie Poluany").toString());
        System.out.println(standardWeatherCache.getWeatherData("Moscow").toString());
        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Berlin").toString());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
