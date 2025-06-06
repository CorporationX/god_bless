package school.faang.module1.bjs2_79786;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        WeatherProvider provider = new WeatherService();

        long maxCacheAgeMillis = 5000;

        log.info("Тест StandardWeatherCache");
        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        testCache(standardCache, maxCacheAgeMillis);

        log.info("Тест FrequentUpdateWeatherCache");
        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);
        testCache(frequentCache, maxCacheAgeMillis);
    }

    private static void testCache(WeatherCacheTemplate cache, long maxCacheAgeMillis) {
        String city = "Minsk";

        WeatherData data1 = cache.getWeatherData(city, maxCacheAgeMillis);
        log.info("Первый запрос: {}", data1);

        WeatherData data2 = cache.getWeatherData(city, maxCacheAgeMillis);
        log.info("Второй запрос: {}", data2);

        WeatherData forced = cache.forceUpdateWeather(city);
        log.info("Принудительное обновление: {}", forced);

        log.info("Кеш до очистки: {}", cache.cache.keySet());
        cache.clearExpiredCache(maxCacheAgeMillis);
        log.info("Кеш после очистки: {}", cache.cache.keySet());
    }
}