package school.faang.caching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherCashTemplateTest {

    private StandardWeatherCache standardWeatherCache;
    private String moscow;
    private long maxCacheAgeMiles;

    @BeforeEach
    public void setUp() {
        standardWeatherCache = new StandardWeatherCache();
        moscow = "Moscow";
        maxCacheAgeMiles = 3600000;
    }

    @Test
    @DisplayName("Получение данных о погоде")
    public void testGetWeatherData() {
        WeatherData weatherData = standardWeatherCache.getWeatherData(moscow, maxCacheAgeMiles);

        assertThat(weatherData).isNotNull();
        assertThat(weatherData.getCity()).isEqualTo(moscow);
        assertThat(weatherData.getHumidity()).isBetween(0.0, 1.0);
        assertThat(weatherData.getTemperature()).isBetween(-35.0, 35.0);
        assertThat(weatherData.getTimestamp()).isLessThan(System.currentTimeMillis() + 1);
    }

    @Test
    @DisplayName("Очистка устаревшего кэша")
    public void testClearExpiredCache() {
        standardWeatherCache.getWeatherData(moscow, maxCacheAgeMiles);
        assertThat(standardWeatherCache.cityWeatherData).isNotEmpty();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        standardWeatherCache.clearExpiredCache(1);
        assertThat(standardWeatherCache.cityWeatherData).isEmpty();
    }
}
