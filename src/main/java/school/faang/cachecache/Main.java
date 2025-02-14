package school.faang.cachecache;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();

        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);

        String city = "Moscow";
        long cacheAge = 5000;

        System.out.println("Standard cache:");
        System.out.println(standardCache.getWeatherData(city, cacheAge));
        Thread.sleep(10000);
        System.out.println(standardCache.getWeatherData(city, cacheAge));
        Thread.sleep(10000);
        System.out.println(standardCache.getWeatherData(city, cacheAge));

        System.out.println("\nFrequent update cache:");
        System.out.println(frequentCache.getWeatherData(city, cacheAge));
        System.out.println(frequentCache.getWeatherData(city, cacheAge));
    }
}
