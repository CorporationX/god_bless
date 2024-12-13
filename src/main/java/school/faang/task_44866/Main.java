package school.faang.task_44866;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();
        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(provider);

        String city = "London";
        long maxCacheAge = 3000;

        log.info("Testing StandardWeatherCache...");
        System.out.println("First fetch: " + standardWeatherCache.getWeatherData(city, maxCacheAge));
        Thread.sleep(2000);
        System.out.println("Second fetch (cache valid): "
                + standardWeatherCache.getWeatherData(city, maxCacheAge));
        Thread.sleep(2000);
        System.out.println("Third fetch (cache expired): "
                + standardWeatherCache.getWeatherData(city, maxCacheAge));

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);
        log.info("Testing FrequentWeatherCache...");
        System.out.println("First fetch: " + frequentCache.getWeatherData(city, maxCacheAge));
        Thread.sleep(2000);
        System.out.println("Second fetch (cache might be expired earlier): "
                + frequentCache.getWeatherData(city, maxCacheAge));
        Thread.sleep(2000);
        System.out.println("Second fetch (likely new data): "
                + frequentCache.getWeatherData(city, maxCacheAge));

        log.info("Clearing expired cache...");
        standardWeatherCache.clearExpiredCache(maxCacheAge);
    }
}
