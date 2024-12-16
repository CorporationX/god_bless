package faang.school.godbless.sprint_2.task_44862.weather_cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherCacheTemplateTest {

    private final WeatherCacheTemplate weatherCacheTemplate = new FrequentUpdateWeatherCache();

    @Test
    void clearExpiredCache() {
        weatherCacheTemplate.getWeatherData("Moscow", 2_000L);
        weatherCacheTemplate.getWeatherData("Samara", 2_000L);
        assertEquals(2, weatherCacheTemplate.getWeatherData().size());

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        weatherCacheTemplate.clearExpiredCache(3_000);

        assertEquals(0, weatherCacheTemplate.getWeatherData().size());
    }
}