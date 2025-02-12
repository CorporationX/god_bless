package school.faang.task_56910;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeatherCacheTemplateTest {

    @Nested
    class WeatherCacheTest {
        private WeatherService weatherService;
        private StandardWeatherCache standardCache;
        private FrequentUpdateWeatherCache frequentCache;

        @BeforeEach
        void setUp() {
            weatherService = new WeatherService();
            standardCache = new StandardWeatherCache(weatherService);
            frequentCache = new FrequentUpdateWeatherCache(weatherService);
        }

        @Test
        void testStandardCacheReturnsFreshDataWithinTimeLimit() {
            String city = "Moscow";
            long cacheDuration = 5000; // 5 секунд
            WeatherData firstFetch = standardCache.getWeatherData(city, cacheDuration);
            WeatherData secondFetch = standardCache.getWeatherData(city, cacheDuration);
            assertEquals(firstFetch.getCity(), secondFetch.getCity());
            assertEquals(firstFetch.getTemperature(), secondFetch.getTemperature(), 0.01);
            assertEquals(firstFetch.getHumidity(), secondFetch.getHumidity(), 0.01);
        }

        @Test
        void testStandardCacheUpdatesDataAfterExpiry() throws InterruptedException {
            String city = "Moscow";
            long cacheDuration = 1000; // 1 секунда
            WeatherData firstFetch = standardCache.getWeatherData(city, cacheDuration);
            Thread.sleep(1500); // Ждем 1.5 секунды
            WeatherData secondFetch = standardCache.getWeatherData(city, cacheDuration);
            assertNotEquals(firstFetch.getTemperature(), secondFetch.getTemperature(), 0.01);
            assertNotEquals(firstFetch.getHumidity(), secondFetch.getHumidity(), 0.01);
        }

        @Test
        void testFrequentUpdateCacheAlwaysFetchesNewData() {
            String city = "Moscow";
            long cacheDuration = 5000; // 5 секунд
            WeatherData firstFetch = frequentCache.getWeatherData(city, cacheDuration);
            WeatherData secondFetch = frequentCache.getWeatherData(city, cacheDuration);
            assertNotEquals(firstFetch.getTemperature(), secondFetch.getTemperature(), 0.01);
            assertNotEquals(firstFetch.getHumidity(), secondFetch.getHumidity(), 0.01);
        }

        @Test
        void testStandardCacheHandlesMultipleCities() throws InterruptedException {
            String city1 = "Moscow";
            String city2 = "Saint Petersburg";
            long cacheDuration = 5000; // 5 секунд
            WeatherData data1 = standardCache.getWeatherData(city1, cacheDuration);
            WeatherData data2 = standardCache.getWeatherData(city2, cacheDuration);
            assertNotEquals(data1.getCity(), data2.getCity());
            assertNotEquals(data1.getTemperature(), data2.getTemperature(), 0.01);
            assertNotEquals(data1.getHumidity(), data2.getHumidity(), 0.01);

            // Проверяем, что данные для города 1 остаются актуальными
            WeatherData data1Again = standardCache.getWeatherData(city1, cacheDuration);
            assertEquals(data1.getCity(), data1Again.getCity());
            assertEquals(data1.getTemperature(), data1Again.getTemperature(), 0.01);
            assertEquals(data1.getHumidity(), data1Again.getHumidity(), 0.01);

            // Ждем, чтобы данные для города 1 устарели
            Thread.sleep(6000);
            WeatherData data1AfterExpiry = standardCache.getWeatherData(city1, cacheDuration);
            assertNotEquals(data1.getTemperature(), data1AfterExpiry.getTemperature(), 0.01);
            assertNotEquals(data1.getHumidity(), data1AfterExpiry.getHumidity(), 0.01);
        }
    }

}