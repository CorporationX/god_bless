package school.faang.sprint1.bjs_44847;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;

public class Main {
    private static final Logger logs = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        WeatherCacheTemplate cache = new StandardWeatherCache();
        String city = "Vancouver";
        long cacheTime = 1000;

        logs.info("Checking data taken from cache - should be equal");
        WeatherData firstRecord = cache.getWeatherData(city, cacheTime);
        WeatherData secondRecord = cache.getWeatherData(city, cacheTime);
        logs.info("Compare: {}", Objects.equals(firstRecord, secondRecord));

        logs.info("Checking data updated (cache expired) - should be not equal");
        WeatherData initialRecord = cache.getWeatherData(city, cacheTime);
        Thread.sleep(cacheTime + 500);
        WeatherData updatedRecord = cache.getWeatherData(city, cacheTime);
        logs.info("Compare: {}", Objects.equals(initialRecord, updatedRecord));

        logs.info("Checking data forced to updated - should be not equal");
        WeatherCacheTemplate cacheForced = new FrequentUpdateWeatherCache();
        WeatherData record1 = cacheForced.getWeatherData(city, cacheTime);
        WeatherData record2 = cacheForced.getWeatherData(city, cacheTime);
        logs.info("Compare: {}", Objects.equals(record1, record2));

        logs.info("Checking clear cache - should be not equal");
        WeatherData oldData = cache.getWeatherData(city, cacheTime);
        Thread.sleep(cacheTime + 500);
        cache.clearExpiredCache(cacheTime);
        WeatherData freshData = cache.getWeatherData(city, cacheTime);
        logs.info("Compare: {}", Objects.equals(oldData, freshData));
        cache.printAllCachedData();
    }
}
