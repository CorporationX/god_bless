package school.faang.task_44825;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FrequentUpdateWeatherCacheTest {
    private final Map<String, WeatherData> data = DataInitializerUtils.initData();
    private final WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(
            data, new WeatherService()
    );

    @Test
    void shouldGetWeatherData() {
        WeatherData oldWeatherData = data.get("Moscow");

        WeatherData actualData = frequentUpdateWeatherCache.getWeatherData("Moscow", 5);

        assertNotEquals(oldWeatherData, actualData);
    }

    @Test
    void shouldClearExpiredCache() {
        frequentUpdateWeatherCache.clearExpiredCache(1);

        assertTrue(data.isEmpty());
    }
}