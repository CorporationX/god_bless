package school.faang.task_44908;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final String city = "New York";
        final String frequentCity = "Seattle";
        final int standardSleep = 3000;
        final int frequentSleep = 1000;
        final int frequentCacheExpiryTime = 500;
        final int cacheExpirationTime = 500;

        WeatherProvider weatherProvider = new WeatherService();
        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(weatherProvider);
        WeatherData weatherData = standardWeatherCache.getWeatherData(city);
        log.info("\nFetched weather data:\n{}", weatherData);

        WeatherData cachedWeatherData = standardWeatherCache.getWeatherData(city);
        log.info("\nFetched cached weather data:\n{}", cachedWeatherData);

        try {
            log.info("\n:: Sleeping thread for {} milliseconds", standardSleep);
            Thread.sleep(standardSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WeatherData refreshedWeatherData = standardWeatherCache.getWeatherData(city);
        log.info("\nFetched refreshed weather data:\n{}", refreshedWeatherData);

        log.info("\n\n\n### FREQUENT UPDATE");

        log.info("\nSetting cache expiry time to {} milliseconds for frequent updates", frequentCacheExpiryTime);

        WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(
                weatherProvider,
                frequentCacheExpiryTime
        );

        WeatherData frequentWeatherData = frequentUpdateWeatherCache.getWeatherData(frequentCity);
        log.info("\nFetched weather data with frequent updates for {}:\n{}", frequentCity, frequentWeatherData);

        try {
            log.info("\n:: Pausing execution for {} milliseconds", frequentSleep);
            Thread.sleep(frequentSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WeatherData frequentUpdatedWeatherData = frequentUpdateWeatherCache.getWeatherData(frequentCity);
        log.info("\nFetched updated weather data with frequent updates for {}:\n{}",
                frequentCity, frequentUpdatedWeatherData
        );

        log.info("\n\n\n### Clearing all cache");
        log.info("\nAttempting to clear expired cache for FREQUENT updates (max age: {} milliseconds)",
                cacheExpirationTime);

        frequentUpdateWeatherCache.clearExpiredCache(cacheExpirationTime);

        log.info("\nAttempting to clear expired cache for STANDARD updates (max age: {} milliseconds)",
                cacheExpirationTime);
        standardWeatherCache.clearExpiredCache(cacheExpirationTime);
    }
}