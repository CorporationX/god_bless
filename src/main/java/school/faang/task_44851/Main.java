package school.faang.task_44851;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();

        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        long maxCacheAgeMillis = 5000;

        System.out.println("Standard Cache:");
        WeatherData data1 = standardCache.getWeatherData("New York", maxCacheAgeMillis);
        System.out.println(data1);

        Thread.sleep(3000);

        WeatherData data2 = standardCache.getWeatherData("New York", maxCacheAgeMillis);
        System.out.println(data2);

        Thread.sleep(3000);

        WeatherData data3 = standardCache.getWeatherData("New York", maxCacheAgeMillis);
        System.out.println(data3);

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);
        System.out.println("Frequent Update Cache:");
        WeatherData frequentCache1 = frequentCache.getWeatherData("London", maxCacheAgeMillis);
        System.out.println(frequentCache1);

        Thread.sleep(3000);

        WeatherData frequentCache2 = frequentCache.getWeatherData("London", maxCacheAgeMillis);
        System.out.println(frequentCache2);

        Thread.sleep(3000);

        WeatherData frequentCache3 = frequentCache.getWeatherData("London", maxCacheAgeMillis);
        System.out.println(frequentCache3);
    }
}
