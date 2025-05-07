package school.faang.bjs244832;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider weatherProvider = new WeatherService();
        WeatherCacheTemplate standardCache = new StandardWeatherCache(weatherProvider);

        System.out.println("Test Cache Data Retrieval:");
        WeatherData data1 = standardCache.getWeatherData("New York", 60000);
        System.out.println("First fetch: " + data1);
        WeatherData data2 = standardCache.getWeatherData("New York", 60000);
        System.out.println("Second fetch: " + data2);
        System.out.println("Data is from cache: " + data1.equals(data2));

        System.out.println("\nTest Force Update Weather:");
        WeatherData data3 = standardCache.getWeatherData("New York", 0);
        System.out.println("Forced update fetch: " + data3);
        System.out.println("Data is updated: " + !data1.equals(data3));

        System.out.println("\nTest Expired Cache Data:");
        long maxCacheAgeMillis = 1000;
        WeatherData data4 = standardCache.getWeatherData("New York", maxCacheAgeMillis);
        System.out.println("First fetch with short cache age: " + data4);
        Thread.sleep(1500);
        WeatherData data5 = standardCache.getWeatherData("New York", maxCacheAgeMillis);
        System.out.println("Second fetch after cache expired: " + data5);
        System.out.println("Data is updated after expiration: " + !data4.equals(data5));

        System.out.println("\nTest Clear Expired Cache:");
        standardCache.getWeatherData("New York", maxCacheAgeMillis);
        Thread.sleep(1500);
        standardCache.clearExpiredCache(maxCacheAgeMillis);
        System.out.println("Cache is empty after clearing expired data: " + standardCache.cache.isEmpty());
    }
}