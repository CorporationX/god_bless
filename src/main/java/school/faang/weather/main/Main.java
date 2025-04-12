package school.faang.weather.main;

import lombok.extern.slf4j.Slf4j;
import school.faang.weather.cache.FrequentUpdateWeatherCache;
import school.faang.weather.cache.StandardWeatherCache;
import school.faang.weather.service.WeatherProvider;
import school.faang.weather.service.WeatherService;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();
        StandardWeatherCache standardCache = new StandardWeatherCache(provider);
        FrequentUpdateWeatherCache frequentCache = new FrequentUpdateWeatherCache(provider);
        long maxCacheAgeMillis = 5000;
        log.info("Requesting weather data for Pskov:");
        log.info(standardCache.getWeatherDataForCity("Pskov", maxCacheAgeMillis).toString());
        log.info("Requesting weather data for Pskov (update):");
        log.info(frequentCache.getWeatherDataForCity("Pskov", maxCacheAgeMillis).toString());
        log.info("Requesting weather data for Moscow:");
        log.info(standardCache.getWeatherDataForCity("Moscow", maxCacheAgeMillis).toString());
        Thread.sleep(2000);
        log.info("Requesting weather data for Moscow after 2 seconds: ");
        log.info(standardCache.getWeatherDataForCity("Moscow", maxCacheAgeMillis).toString());
        Thread.sleep(4000);
        log.info("Requesting weather data for Moscow after 4 seconds: ");
        log.info(standardCache.getWeatherDataForCity("Moscow", maxCacheAgeMillis).toString());

    }
}
