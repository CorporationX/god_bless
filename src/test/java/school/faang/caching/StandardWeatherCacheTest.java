package school.faang.caching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StandardWeatherCacheTest {

    private StandardWeatherCache standardWeatherCache;
    private String moscow;

    @BeforeEach
    public void setUp() {
        standardWeatherCache = new StandardWeatherCache();
        moscow = "Moscow";
    }

    @Test
    @DisplayName("Использование кэша и обновление данных по необходимости")
    public void testGetWeatherData() {
        WeatherData firstData = standardWeatherCache.getWeatherData(moscow, 5000);
        WeatherData secondData = standardWeatherCache.getWeatherData(moscow, 5000);

        assertThat(firstData).isEqualTo(secondData);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WeatherData thirdData = standardWeatherCache.getWeatherData(moscow, 5000);

        assertThat(thirdData).isNotEqualTo(firstData);
    }

    @Test
    @DisplayName("Данные удаляются по истечение кэша")
    public void testGetWeatherDate_deleteOld() {
        standardWeatherCache.getWeatherData(moscow, 5000);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        standardWeatherCache.clearExpiredCache(5000);

        assertThat(standardWeatherCache.cityWeatherData).isEmpty();
    }
}
