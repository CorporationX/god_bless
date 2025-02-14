package school.faang.cachecache;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();

        String city = "Moscow";
        long cacheAge = 5000;

        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        System.out.println("Standard cache:");
        System.out.println(standardCache.getWeatherData(city, cacheAge));
        Thread.sleep(10000);
        System.out.println(standardCache.getWeatherData(city, cacheAge));
        Thread.sleep(10000);
        System.out.println(standardCache.getWeatherData(city, cacheAge));

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);
        System.out.println("\nFrequent update cache:");
        System.out.println(frequentCache.getWeatherData(city, cacheAge));
        System.out.println(frequentCache.getWeatherData(city, cacheAge));
    }
}
