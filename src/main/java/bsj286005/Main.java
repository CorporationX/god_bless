package bsj286005;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();

        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);

        long maxCacheAge = 3000;

        System.out.println("--- Standard Cache Demo ---");
        WeatherData d1 = standardCache.getWeatherData("Moscow", maxCacheAge);
        System.out.println("First request: " + d1);

        Thread.sleep(1000);
        WeatherData d2 = standardCache.getWeatherData("Moscow", maxCacheAge);
        System.out.println("Second request (should be from cache): " + d2);

        Thread.sleep(2500);
        WeatherData d3 = standardCache.getWeatherData("Moscow", maxCacheAge);
        System.out.println("Third request (should refresh): " + d3);

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);

        System.out.println("\n--- Frequent Update Cache Demo ---");
        WeatherData d4 = frequentCache.getWeatherData("London", maxCacheAge);
        System.out.println("First request: " + d4);
        WeatherData d5 = frequentCache.getWeatherData("London", maxCacheAge);
        System.out.println("Second request (always refreshes): " + d5);

        System.out.println("\n--- Testing forceUpdateWeather ---");
        WeatherData d6 = standardCache.getWeatherData("Paris", maxCacheAge);
        System.out.println("First request: " + d6);
        standardCache.forceUpdateWeather("Paris");
        System.out.println("Forced update: " + standardCache.getWeatherData("Paris", maxCacheAge));

        System.out.println("\n--- Testing clearExpiredCache ---");
        standardCache.forceUpdateWeather("Berlin");
        Thread.sleep(3000);
        standardCache.clearExpiredCache(maxCacheAge);
        System.out.println("Cache after clearing expired: " + standardCache.getWeatherCash());
    }
}
