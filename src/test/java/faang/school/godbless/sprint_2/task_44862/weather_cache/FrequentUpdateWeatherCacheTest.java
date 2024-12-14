package faang.school.godbless.sprint_2.task_44862.weather_cache;

import faang.school.godbless.sprint_2.task_44862.WeatherData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequentUpdateWeatherCacheTest {

    private final FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

    @Test
    void testGetWeatherData() {
        assertEquals(0, frequentUpdateWeatherCache.getWeatherData().size());

        WeatherData moscowWeatherData = frequentUpdateWeatherCache.getWeatherData("Moscow", 2_000L);
        WeatherData samaraWeatherData = frequentUpdateWeatherCache.getWeatherData("Samara", 2_000L);

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WeatherData newMoscowWeatherData = frequentUpdateWeatherCache.getWeatherData("Moscow", 2_000L);
        WeatherData newSamaraWeatherData = frequentUpdateWeatherCache.getWeatherData("Samara", 2_000L);

        assertNotEquals(moscowWeatherData, newMoscowWeatherData);
        assertNotEquals(samaraWeatherData, newSamaraWeatherData);
        assertEquals(2, frequentUpdateWeatherCache.getWeatherData().size());
    }
}