package school.faang.cacheCache;

public class CacheTesting {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();

        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);

        String city = "Moscow";

        long maxCacheAgeMillis = 5000;

        System.out.println("Тестирование StandardWeatherCache ");
        WeatherData data1 = standardCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Первый вызов: " + data1);

        Thread.sleep(2000);
        WeatherData data2 = standardCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Второй вызов (через 2 сек): " + data2);

        Thread.sleep(4000);
        WeatherData data3 = standardCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Третий вызов (через 6 сек): " + data3);

        System.out.println("\nТестирование FrequentUpdateWeatherCache");

        WeatherData freqData1 = frequentCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Первый вызов: " + freqData1);

        Thread.sleep(1000);
        WeatherData freqData2 = frequentCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Второй вызов (через 1 сек): " + freqData2);

    }
}
