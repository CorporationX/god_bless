package school.faang.caching;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherCacheTemplate standardCache = new StandardWeatherCache(new WeatherService());
        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(new WeatherService());
        System.out.println(frequentCache.getWeatherData("Moskov", 10000));
        System.out.println(frequentCache.getWeatherData("Moskov", 10000));
        System.out.println(frequentCache.getWeatherData("Moskov", 0));
        System.out.println(standardCache.getWeatherData("Moskov", 10000));
        System.out.println(standardCache.getWeatherData("Moskov", 10000));
        System.out.println(standardCache.getWeatherData("Moskov", 0));
        System.out.println(standardCache.getWeatherData("Moskov", 10));
        System.out.println(standardCache.getWeatherData("Test", 10000));
        Thread.sleep(1000);
        standardCache.clearExpiredCache(100);
        System.out.println(standardCache.getWeatherData("Test", 10000));
        System.out.println(standardCache.getWeatherData("Moskov", 10));
        System.out.println();
    }
}
