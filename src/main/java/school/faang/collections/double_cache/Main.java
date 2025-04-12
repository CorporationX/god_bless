package school.faang.collections.double_cache;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import school.faang.collections.double_cache.templates.FrequentUpdateWeatherCache;
import school.faang.collections.double_cache.templates.StandardWeatherCache;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        StandardWeatherCache weatherCache = new StandardWeatherCache();
        FrequentUpdateWeatherCache frequentWeatherCache = new FrequentUpdateWeatherCache();

        log.info(weatherCache.getWeatherData("Moscow", 5000).toString());
        log.info(weatherCache.getWeatherData("London", 10000).toString());
        log.info(frequentWeatherCache.getWeatherData("Moscow", 1000).toString());
        log.info(frequentWeatherCache.getWeatherData("London", 10000).toString());

        log.info("Pause 2 sec");
        Thread.sleep(2000);
        log.info(weatherCache.getWeatherData("Moscow", 5000).toString());
        log.info(weatherCache.getWeatherData("London", 10000).toString());
        log.info(frequentWeatherCache.getWeatherData("Moscow", 5000).toString());
        log.info(frequentWeatherCache.getWeatherData("London", 10000).toString());

        log.info("Pause 3,5 sec");
        Thread.sleep(3500);
        log.info(weatherCache.getWeatherData("Moscow", 5000).toString());
        log.info(weatherCache.getWeatherData("London", 10000).toString());
        log.info(frequentWeatherCache.getWeatherData("Moscow", 5000).toString());
        log.info(frequentWeatherCache.getWeatherData("London", 10000).toString());

        log.info(weatherCache.getWeatherDataCache().toString());
        log.info("Pause 4 sec");
        Thread.sleep(4000);
        weatherCache.clearExpiredCache(6000);
        log.info(weatherCache.getWeatherDataCache().toString());
    }
}
