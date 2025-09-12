package school.faang.bjs2_86085;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FrequentUpdateWeatherCacheTest {
    private final WeatherService provider = new WeatherService();

    @Test
    void testFrequentCacheReturnsDifferentData() {
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(provider);

        WeatherData d1 = cache.getWeatherData("Paris", 1000);
        WeatherData d2 = cache.getWeatherData("Paris", 1000);

        // FrequentUpdateWeatherCache должен возвращать РАЗНЫЕ данные
        // потому что он обновляется очень часто или не кэширует вообще
        assertNotEquals(d1.getTemperature(), d2.getTemperature());
        assertNotEquals(d1.getHumidity(), d2.getHumidity());
        assertEquals(d1.getCity(), d2.getCity()); // только город должен совпадать
    }

    @Test
    void testFrequentCacheSameCity() {
        WeatherCacheTemplate cache = new FrequentUpdateWeatherCache(provider);

        WeatherData d1 = cache.getWeatherData("London", 5000);
        WeatherData d2 = cache.getWeatherData("London", 5000);

        // Город должен оставаться тем же
        assertEquals("London", d1.getCity());
        assertEquals("London", d2.getCity());
    }
}